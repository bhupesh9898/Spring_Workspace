package com.zensar.spring.beans;

public class Employee {

	private int employeeId;
	private String employeeName;
	private int Salary;
	private Address address;

	public Employee() {
		super();
		System.out.println("Test for cons");
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(int employeeId, String employeeName, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		Salary = salary;
	}

	public Employee(int employeeId, String employeeName, int salary, Address address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		Salary = salary;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", Salary=" + Salary
				+ ", address=" + address + "]";
	}

	

}
