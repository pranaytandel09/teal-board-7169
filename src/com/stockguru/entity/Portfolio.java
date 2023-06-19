package com.stockguru.entity;

import java.io.Serializable;

public class Portfolio implements Serializable{

	
	private String name;
	private String username;
	private double buyingPrice;
	private int quantity;
	
	public Portfolio() {
		
	}

	public Portfolio(String name, String username, int quantity,double buyingPrice) {
		super();
		this.name = name;
		this.username = username;
		this.quantity = quantity;
		this.setBuyingPrice(buyingPrice);
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	@Override
	public String toString() {
		return "Portfolio [name=" + name + ", username=" + username + ", buyingPrice=" + buyingPrice + ", quantity="
				+ quantity + "]";
	}
	
	

}
