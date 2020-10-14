package com.zensar.spring.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	private int studentId;
	private List<String> studentName;
	private int studentMarks;
	private Set<Address> address;
	private Map<String ,Certification > certification;
	private Properties books;
	private String[] hobbies;
	

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Properties getBooks() {
		return books;
	}

	public void setBooks(Properties books) {
		this.books = books;
	}

	public Map<String, Certification> getCertification() {
		return certification;
	}

	public void setCertification(Map<String, Certification> certification) {
		this.certification = certification;
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

	

	

	public List<String> getStudentName() {
		return studentName;
	}

	public void setStudentName(List<String> studentName) {
		this.studentName = studentName;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", address=" + address + ", certification=" + certification + ", books=" + books + ", Hobbies="
				+ Arrays.toString(hobbies) + "]";
	}


	
	
	
	

}
