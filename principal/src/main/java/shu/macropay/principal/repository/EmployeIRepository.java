package shu.macropay.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import shu.macropay.principal.model.Employee;

public interface EmployeIRepository extends JpaRepository<Employee, Long> {

	void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

	
}
