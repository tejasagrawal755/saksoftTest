package Com.crud.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.crud.employee.model.Employee;
import Com.crud.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return service.findAllEmployees();

	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return service.findEmployeeById(id);

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return service.deleteEmployee(id);

	}

}
