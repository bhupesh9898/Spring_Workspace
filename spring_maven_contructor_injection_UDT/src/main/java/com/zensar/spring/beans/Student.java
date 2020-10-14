package com.zensar.spring.beans;

import java.util.List;

public class Student {
	private int studentId;
	private String studentName;
	private int studentMarks;
	private List<Address> address;




	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	


	

	

	
	public Student(int studentId, String studentName, int studentMarks, List<Address> address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.address = address;
	}

	public Student() {
		super();
		System.out.println("Inside stud cons");
	}

	public int getStudentId() {
		return studentId;

	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	

	

	

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", address=" + address + "]";
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}





	
	

	
	
	
	

}
