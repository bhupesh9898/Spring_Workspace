package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Employee;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {

	private List<Employee> employees = new ArrayList<Employee>();

	public EmployeeResource() {

		System.out.println("Inside Constructor()...!!!");
		employees.add(new Employee(101, "Gourav", 10006));
		employees.add(new Employee(102, "Avina", 10005));
		employees.add(new Employee(103, "Amit", 10002));
		employees.add(new Employee(104, "Bhupesh", 10001));
		employees.add(new Employee(105, "Shivam", 10009));
	}

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees() Method Called...!!!!");
		return employees;
	}

	@PostMapping(value = "/employees")
	public void insertEmployee(@RequestBody Employee employee) {
		System.out.println("insertEmployee() Method Called...!!!!");
		employees.add(employee);
	}

	@DeleteMapping("employees/{employeeId}")
	public void deleteEmployeee(@PathVariable("employeeId") int employeeId) {
		System.out.println("deleteEmployeee() Method Called...!!!!");
		for (Employee e : employees) {
			if (e.getEmployeeId() == employeeId) {
				employees.remove(e);
				break;
			}
		}
	}

	@PatchMapping(value = "/employees")
	public void updateEmployee(@RequestBody Employee updatedEmployee) {
		System.out.println("updateEmployee() Method Called...!!!!");
		for (Employee e : employees) {
			if (e.getEmployeeId() == updatedEmployee.getEmployeeId()) {
				employees.remove(e);
				employees.add(updatedEmployee);
				break;
			}
		}
	}

}
