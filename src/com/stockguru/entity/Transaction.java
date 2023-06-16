package com.stockguru.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable{
	
	private String name;
	private String username;
	private String email;
	private double buyingPrice;
	private int quantity;
	private LocalDate dt;
	
	public Transaction() {
		
	}

	public Transaction(String name,String username, String email, double buyingPrice, int qty, LocalDate now) {
		// TODO Auto-generated constructor stub
		this.name= name;
		this.username=username;
		this.email=email;
		this.buyingPrice=buyingPrice;
		this.quantity=qty;
		this.dt=now;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getNow() {
		return dt;
	}

	public void setNow(LocalDate now) {
		this.dt = now;
	}

	@Override
	public String toString() {
		return "Transaction [name=" + name + ", username=" + username + ", email=" + email + ", buyingPrice="
				+ buyingPrice + ", quantity=" + quantity + ", dt=" + dt + "]";
	}

	
}
