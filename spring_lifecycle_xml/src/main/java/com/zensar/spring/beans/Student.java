package com.zensar.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean,DisposableBean{
	private int studentId;
	private String studentName;
	private int studentMarks;

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
				+ "]";
	}
	
	public void myInit() {
		System.out.println("inside myInit");
	}

	public void myDestroy() {
		System.out.println("inside myDestroy");
	}

	public void destroy() throws Exception {
		System.out.println("inside public void destroy()");
		
	}

	public void afterPropertiesSet() throws Exception {
	
		System.out.println("inside void afterPropertiesSet()");
	}
}
