package com.anitha.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anitha.demo.enums.Department;
import com.anitha.demo.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>
{
	List<Employee> findByDepartmentAndYearOfJoiningGreaterThanEqual(Department department, int year);

}
