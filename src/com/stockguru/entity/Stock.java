package com.stockguru.entity;

import java.io.Serializable;

public class Stock implements Serializable{

	private String name;
	private int price;
	
	public Stock() {
		super();
		
	}
	
	public Stock(String name, int i) {
		super();
		this.name = name;
		this.price = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", price=" + price + "]";
	}
	
	
}
