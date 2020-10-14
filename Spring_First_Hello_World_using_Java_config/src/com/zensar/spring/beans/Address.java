package com.zensar.spring.beans;

public class Address {
	private int pincode;
	private String city;
	private String state;
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address(int pincode, String city, String state) {
		super();
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
