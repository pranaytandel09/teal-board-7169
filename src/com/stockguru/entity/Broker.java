package com.stockguru.entity;

import java.io.Serializable;

public class Broker implements Serializable{

	private String brokerId;
	private String brokerPassword;
	private int age;
	private int experience;
	private int qualification;
	private String email;
	
	public Broker(){
		super();
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerPassword() {
		return brokerPassword;
	}

	public void setBrokerPassword(String brokerPassword) {
		this.brokerPassword = brokerPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Broker [brokerId=" + brokerId + ", brokerPassword=" + brokerPassword + ", age=" + age + ", experience="
				+ experience + ", qualification=" + qualification + ", email=" + email + "]";
	}
	
	
	
	
}
