package com.stockguru.entity;

import java.io.Serializable;

public class Trader implements Serializable{

	private String username;
	private String password;
	private int age;
	private double walletAmount;
	private String email;
	
	
	
	public Trader(String username, String password, int age, double walletAmount, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.walletAmount = walletAmount;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Trader [username=" + username + ", password=" + password + ", age=" + age + ", walletAmount="
				+ walletAmount + ", email=" + email + "]";
	}
	
	
}
