package Oussama.Training.employee.backend.repository;

import Oussama.Training.employee.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
