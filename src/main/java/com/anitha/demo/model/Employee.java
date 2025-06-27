package com.anitha.demo.model;

import jakarta.persistence.*;
import com.anitha.demo.enums.Department;
import jakarta.validation.constraints.*; 



@Entity
@Table(name = "employees") 
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @NotBlank(message = "Employee name is required")
    private String empName;

    @Min(value = 2000, message = "Year must be after 1900")
    @Max(value = 2100, message = "Year must be before 2100")
    private int yearOfJoining;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Department must be selected")
    private Department department; 

    public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public  @NotNull(message = "Department must be selected") Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
	    this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + empId + ", EmpName=" + empName + ", YearOfJoining=" + yearOfJoining
				+ ", Department=" + department + "]";
	}
	

}
