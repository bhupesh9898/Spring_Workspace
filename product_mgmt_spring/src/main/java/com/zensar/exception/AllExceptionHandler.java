package com.zensar.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {
	@ExceptionHandler
	public String handleExceptuin(Exception exception) {
		return "exception";
	}
}
