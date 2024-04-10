package Oussama.Training.employee.backend.service;

import Oussama.Training.employee.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto>getAllEmployees();
    EmployeeDto updateEmployee(long employeeId,EmployeeDto updateEmployee);
    void deleteEmployee(long employeeId);

}
