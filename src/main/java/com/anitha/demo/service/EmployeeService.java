package com.anitha.demo.service;

import com.anitha.demo.model.Employee;
import com.anitha.demo.enums.Department;
import com.anitha.demo.dao.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;
    
    public List<Employee> getAllEmployees() {
        return (List<Employee>) repo.findAll();
    }
   
    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }
   
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }
    public List<Employee> getByDepartmentAndYear(Department dept, int year) {
        return repo.findByDepartmentAndYearOfJoiningGreaterThanEqual(dept, year);
    }
}
