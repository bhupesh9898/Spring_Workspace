package com.zensar.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.User;
import com.zensar.service.UserService;

@RestController
@RequestMapping(value = "/user", 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
public class UserResource {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		int result = userService.register(user);
		if (result == 400) {
			return new ResponseEntity<String>("Not a Valid Email Id", HttpStatus.NOT_ACCEPTABLE);
		}
		if (result == 200) {
			return new ResponseEntity<String>("Successfully Registered", HttpStatus.CREATED);
		}
		return null;
	}

	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody User user,HttpSession session) {

		//System.out.println("Email " + email + "Password " + password);
		int result = userService.login(user.getEmail(), user.getPassword());
		if (result == 400) {
			return new ResponseEntity<String>("Not a Registered Email Id", HttpStatus.UNAUTHORIZED);
		}
		if (result == 200) {
			session.setAttribute("user", userService.getUserByEmail(user.getEmail()));
			return new ResponseEntity<String>("Logged in Successfully", HttpStatus.ACCEPTED);
		}
		if (result == 401) {
			return new ResponseEntity<String>("Wrong Password", HttpStatus.UNAUTHORIZED);
		}
		return null;

	}

	@GetMapping(value = "/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ResponseEntity<String>("Logged out successfully...", HttpStatus.OK);
	}

}
