package edu.esprit.onlinestore.domain;

import java.io.Serializable;

public class Product implements Serializable {
	
	private String designation;
	private Float price;
	
	public Product() {
	}
	

	public Product(String designation, Float price) {
		super();
		this.designation = designation;
		this.price = price;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}
