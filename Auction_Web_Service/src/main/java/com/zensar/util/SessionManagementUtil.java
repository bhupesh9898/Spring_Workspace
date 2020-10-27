package com.zensar.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SessionManagementUtil {
	/*

	// Supposing that it is login request
	@PostMapping(value = "/employees/login")
	public void loginEmployee(@RequestBody Employee employee, HttpSession session) {
		if (session.getAttribute("user") == null) {
			session.setAttribute("user", employee);
			System.out.println("session value in loginEmployee :- " + session.getAttribute("user"));
			System.out.println("Login successfull....");
		} else {
			System.out.println("Already logged in user...");
			// It is already logged in so send correct response code
		}
	}

	// http://localhost:8080/api/get/employees
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees(HttpServletRequest request) {
		System.out.println("session value in getAllEmployees :- " + request.getSession().getAttribute("user"));
		if (request.getSession().getAttribute("user") != null) {
			System.out.println("Authentication successfull....");
			return employees;
		} else {
			System.out.println("Not an authenticated user...");
			return null;
		}
	}

	@GetMapping("/logout")
	public int logout(HttpServletRequest request) {
		request.getSession().invalidate();
		System.out.println("Session value in logout :- " + request.getSession().getAttribute("user"));
		System.out.println("Logged out successfully...");
		return 1;
	}
	*/

}
