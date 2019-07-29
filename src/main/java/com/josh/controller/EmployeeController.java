package com.josh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josh.dao.EmployeeDAO;
import com.josh.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO empDAO;
	
	// To save an employee
	@PostMapping("/employees")
	public Employee createEmpolyee(@Valid @RequestBody Employee emp)
	{
		return empDAO.save(emp);
	}
	
	// To get all employees
	@GetMapping("/employees")
	public List<Employee> getAll()
	{
		return empDAO.findAll();
	}
	
	// To get an employee
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> get(@PathVariable(value="id") Long id)
	{
		Employee emp = empDAO.find(id);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	
	//To update an employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> update(@PathVariable(value="id") Long id, @RequestBody Employee emp)
	{
		Employee employee = empDAO.find(id);
		employee.setDesignation(emp.getDesignation());
		employee.setExpertise(emp.getExpertise());
		
		Employee updatedEmployee = empDAO.save(employee);
		return ResponseEntity.ok().body(updatedEmployee);
	}
	
	// To delete en employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> delete(@PathVariable(value="id") Long id)
	{
		Employee emp = empDAO.find(id);
		if(emp == null)
		{
			return ResponseEntity.notFound().build();
		}
		empDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	
}
