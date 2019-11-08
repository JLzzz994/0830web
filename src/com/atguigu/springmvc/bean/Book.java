package com.atguigu.springmvc.bean;

public class Book {
	
	private String bookName;
	private Double price;
	private String author;
	
	//Õ®—∂µÿ÷∑
	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", price=" + price + ", author=" + author + ", address=" + address + "]";
	}
	
	
	

}
