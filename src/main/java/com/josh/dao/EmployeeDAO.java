package com.josh.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josh.model.Employee;
import com.josh.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository empRepo;
	
	/* save an employee */
	public Employee save(Employee emp)
	{
		return empRepo.save(emp);
	}
	
	/* get all employees */
	
	public List<Employee> findAll()
	{
		return empRepo.findAll();
	}
	
	/* get an employee*/
	public Employee find(Long id)
	{
		return empRepo.findOne(id);
	}
		
	/* delete an employee */
	public void delete(Employee emp)
	{
		empRepo.delete(emp);
	}
	
}
