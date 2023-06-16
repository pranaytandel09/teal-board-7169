package com.stockguru.services;


//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
import java.util.Map;

import com.stockguru.exceptions.InvalidDetailsException;
import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.entity.Broker;



public class BrokerServicesImpl implements BrokerServices {

	public boolean login(String brokerUsername, String brokerPass, Map<String, Broker> broker) throws  InvalidDetailsException{
		
if (broker.containsKey(brokerUsername) ) {
			
			if(broker.get(brokerUsername).getBrokerPassword().equals(brokerPass)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}
	}

	@Override
	public void signUp(Broker brk, Map<String, Broker> broker) throws DuplicateDataException {
		// TODO Auto-generated method stub
		
		if (broker.containsKey(brk.getBrokerUsername())) {
			
			throw new DuplicateDataException("Customer already exists , please login");
			
		} else {

			broker.put(brk.getBrokerUsername(), brk);

		}
	}
	
	
}
