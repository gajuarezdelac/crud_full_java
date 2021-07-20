package shu.macropay.principal.service;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shu.macropay.principal.exception.UserNotFoundException;
import shu.macropay.principal.model.Employee;
import shu.macropay.principal.repository.EmployeIRepository;


@Service
@Transactional
public class EmployeeService {
	
	private final EmployeIRepository employeIRepository;
	
	@Autowired
	public EmployeeService(EmployeIRepository employeIRepository) {
		
		this.employeIRepository = employeIRepository;
	}
	
	public Employee addEmployee(Employee employee) {	
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeIRepository.save(employee);	
	}
	
	public List<Employee> findAllEmployees() {
		return employeIRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeIRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		employeIRepository.deleteEmployeeById(id);
	}
	
	
	public Employee findEmployeeById(Long id) {
        return employeIRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
	
 	

}
