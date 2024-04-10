package Oussama.Training.employee.backend.service.impl;
import Oussama.Training.employee.backend.dto.EmployeeDto;
import Oussama.Training.employee.backend.entity.Employee;
import Oussama.Training.employee.backend.exception.ResourceNotFoundException;
import Oussama.Training.employee.backend.mapper.EmployeeMapper;
import Oussama.Training.employee.backend.repository.EmployeeRepository;
import Oussama.Training.employee.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
   private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee =EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return  EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exists with given id"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(long employeeId, EmployeeDto updateEmployee) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exists with given id"+employeeId));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee updatEmployeeObject=employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(updatEmployeeObject) ;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exists with given id"+employeeId));
        employeeRepository.deleteById(employeeId);


    }
}
