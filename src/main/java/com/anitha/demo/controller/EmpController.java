package com.anitha.demo.controller;

import com.anitha.demo.enums.Department;
import com.anitha.demo.model.Employee;
import com.anitha.demo.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmployeeService employeeService;
    
    @ModelAttribute("departments")
    public Department[] populateDepartments() {
        return Department.values();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @GetMapping("/allEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employeeDetails";
    }

    @GetMapping("/searchById")
    public String searchById(@RequestParam("id") int id, Model model) {
        Employee emp = employeeService.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "searchByIdResult";
    }
    @PostMapping("/searchByDepartment")
    public String searchByDepartment(@RequestParam("department") String dept,
                                     @RequestParam("year") int year,
                                     Model model) {
        Department departmentEnum = Department.valueOf(dept);
        List<Employee> list = employeeService.getByDepartmentAndYear(departmentEnum, year);
        model.addAttribute("employees", list);
        model.addAttribute("deptName", dept);
        return "searchByDepartmentResult";
    }


    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee emp,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index"; // Return to form with error messages
        }
        employeeService.saveEmployee(emp);
        return "redirect:/allEmployees";
    }
}
