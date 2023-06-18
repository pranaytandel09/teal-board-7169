package com.stockguru.services;
import com.stockguru.exceptions.AccountException;
import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.exceptions.InvalidDetailsException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.entity.Broker;

public interface BrokerServices {

	public boolean login(String brokerUsername, String brokerPass, Map<String, Broker> broker) throws InvalidDetailsException;

	public void signUp(Scanner sc, Map<String, Broker> broker) throws DuplicateDataException;

	public List<Broker> viewAllBrokers(Map<String, Broker> broker) throws AccountException;

	
		
		
	

	
}
