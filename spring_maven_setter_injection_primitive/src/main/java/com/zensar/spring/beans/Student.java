package com.zensar.spring.beans;

public class Student {
	private int studentId;
	private String studentName;
	private int studentMarks;
	private Address address;

	public Student() {
		super();
		System.out.println("Inside stud cons");
	}

	public int getStudentId() {
		return studentId;

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", address=" + address + "]";
	}

	
}
