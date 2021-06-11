package com.nagarro.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employeemanagement.model.Employee;
import com.nagarro.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// displaying list of all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	// updating employee by id
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		employeeService.updateEmployee(e, id);
	}

	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.deleteEmployeeByID(id);
	}

}