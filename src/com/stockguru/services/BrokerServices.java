package com.stockguru.services;
import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.exceptions.InvalidDetailsException;
import java.util.Map;

import com.stockguru.entity.Broker;

public interface BrokerServices {

	public boolean login(String brokerUsername, String brokerPass, Map<String, Broker> broker) throws InvalidDetailsException;

	public void signUp(Broker brk, Map<String, Broker> broker) throws DuplicateDataException;

	
		
		
	

	
}
