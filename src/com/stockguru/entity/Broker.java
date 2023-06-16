package com.stockguru.entity;

import java.io.Serializable;

public class Broker implements Serializable{

	private String brokerUsername;
	private String brokerPassword;
	private int age;
	private int experience;
	private int qualification;
	private String email;
	
	public Broker(){
		super();
	}
	

	public Broker(String brokerUsername, String brokerPassword, int age, int experience, int qualification,
			String email) {
		super();
		this.brokerUsername = brokerUsername;
		this.brokerPassword = brokerPassword;
		this.age = age;
		this.experience = experience;
		this.qualification = qualification;
		this.email = email;
	}


	public String getBrokerUsername() {
		return brokerUsername;
	}

	public void setBrokerId(String brokerUsername) {
		this.brokerUsername = brokerUsername;
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
		return "Broker [brokerUsername=" + brokerUsername + ", brokerPassword=" + brokerPassword + ", age=" + age + ", experience="
				+ experience + ", qualification=" + qualification + ", email=" + email + "]";
	}
	
	
	
	
}
