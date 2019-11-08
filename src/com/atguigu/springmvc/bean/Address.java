package com.atguigu.springmvc.bean;

public class Address {
	
	private String addressNum;
	private String addressLoc;
	public String getAddressNum() {
		return addressNum;
	}
	public void setAddressNum(String addressNum) {
		this.addressNum = addressNum;
	}
	public String getAddressLoc() {
		return addressLoc;
	}
	public void setAddressLoc(String addressLoc) {
		this.addressLoc = addressLoc;
	}
	@Override
	public String toString() {
		return "Address [addressNum=" + addressNum + ", addressLoc=" + addressLoc + "]";
	}
	public Address(String addressNum, String addressLoc) {
		super();
		this.addressNum = addressNum;
		this.addressLoc = addressLoc;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
