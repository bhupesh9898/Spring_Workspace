package com.zensar.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shapeable {
	public String area() {
		return "Area of Circle";
	}

}
