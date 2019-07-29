package com.josh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
