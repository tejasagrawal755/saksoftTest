package Com.crud.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.crud.employee.model.Employee;
import Com.crud.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> saveEmployees(List<Employee> employee) {
		return repository.saveAll(employee);
	}

	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	public Employee findEmployeeById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public String deleteEmployee(Long id) {
		repository.deleteById(id);
		return "employee removed !! " + id;
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setAge(employee.getAge());
		return repository.save(existingEmployee);
	}

}
