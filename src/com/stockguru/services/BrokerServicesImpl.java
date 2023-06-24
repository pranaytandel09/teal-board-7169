package com.stockguru.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.exceptions.InvalidDetailsException;
import com.stockguru.exceptions.AccountException;
import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.entity.Broker;
import com.stockguru.entity.Trader;



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
	public void signUp(Scanner sc, Map<String, Broker> broker, LinkedHashSet<Broker> bset) throws DuplicateDataException {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to Signup for broker's account");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();

		System.out.println("Enter the email id");
		String email = sc.next();
		System.out.println("Enter the age");
		int age = sc.nextInt();
		System.out.println("Enter the Experience");
		int exp = sc.nextInt();
		System.out.println("Enter the Qualification");
		int qualification = sc.nextInt();
		
		Broker brk = new Broker(name, pass, age, exp, qualification, email);
		
		if (broker.containsKey(brk.getBrokerUsername())) {
			
			throw new DuplicateDataException("Customer already exists , please login");
			
		} else {

			broker.put(brk.getBrokerUsername(), brk);
			bset.add(brk);
            
		}
	}

	@Override
	public List<Broker> viewAllBrokers(Map<String, Broker> broker) throws AccountException {
		// TODO Auto-generated method stub
         List<Broker>list=null;
		
		if(broker!=null && broker.size()>0) {
			
			Collection<Broker> col= broker.values();
			list= new ArrayList<>(col);
			
		}else {
			throw new AccountException("Trader account list is empty");
		}
		
		
		return list;
	}
	
	
}
