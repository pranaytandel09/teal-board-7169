package com.stockguru;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.exceptions.InvalidDetailsException;
import com.masai.entities.Customer;
import com.stockguru.entity.Admin;
import com.stockguru.entity.Broker;
import com.stockguru.entity.Trader;
import com.stockguru.entity.Transaction;
import com.stockguru.services.*;
import com.stockguru.utils.FileExist;


public class Main {

	public static void adminFunctionality(Scanner sc, Map<String, Broker> broker, Map<String, Trader> trader, List<Transaction> transactions)
	throws InvalidDetailsException{
		
		adminLogin(sc);
		
		AdminServices adminService= new AdminServicesImpl();
		BrokerServices brokerService= new BrokerServicesImpl();
		TraderServices traderService= new TraderServicesImpl();
		TransactionServices transactionService= new TransactionServicesImpl();
		int choice=0;
		try {
			
			do {
//				System.out.println("Press 1 approve/reject broker's accounts");
				System.out.println("Press 2 view all broker's accounts");
				System.out.println("Press 3 view all trader's accounts");
				System.out.println("Press 4 to view all transactions");
				System.out.println("Press 5 to view all filterdTransactions");
			
				System.out.println("Press 6 to log out");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddProduct(sc, products, prodService);
					System.out.println(added);
					break;
				case 2:

					ViewAllBrokerAcc(broker, brokerService);
					break;
				case 3:

					adminDeleteProduct(sc, products, prodService);
					break;
				case 4:

					String upt = adminUpdateProduct(sc, products, prodService);
					System.out.println(upt);
					break;
				case 5:
					adminViewAllCustomers(customers, cusService);

					break;
				case 6:
					adminViewAllTransactions(transactions, trnsactionService);
					break;
				case 7:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 6);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void adminLogin(Scanner sc) {
		
		System.out.println("Please provide the admin credentials.");
		System.out.println("Enter UserName");
		String userName= sc.next();
		
		System.out.println("Enter Password");
		String passWord= sc.next();
		
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}
	
public static void ViewAllBrokerAcc(Map<String, Broker> broker, BrokerServices brokerService) {
	
	List<Broker> list = brokerService.viewAllBrokers(broker);

	for (Broker b : list) {
		System.out.println(b);
	}
}
public static void brokerFunctionality(Scanner sc, Map<String, Broker> broker, Map<String, Trader> trader, List<Transaction> transactions){
		
		
	}
	
public static void brokerSignup(Scanner sc, Map<String, Broker> broker) {
	
	
}

public static void traderFunctionality(Scanner sc, Map<String, Broker> broker, Map<String, Trader> trader, List<Transaction> transactions){
	
	
}

public static void traderSignup(Scanner sc, Map<String, Broker> broker) {
	
	
}

	public static void main(String[] args) {
		
		//file check
				Map<String, Broker> broker = FileExist.brokerFile();
				Map<String, Trader> trader = FileExist.traderFile();
				List<Transaction> transactions = FileExist.transactionFile();
//				System.out.println(products.size());
//				System.out.println(customers.size());
//				System.out.println(transactions.size());
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to Trader's Mart...");
		
		int preference=0;
		try {
			
			System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Broker login , "
					+ "'3' --> Broker signup, '4' --> Trader Login, '5' --> Trader Signup, '0' --> exit ");
			 preference= sc.nextInt();
			
			do {
				switch(preference) {
				
				case 1: 
					adminFunctionality(sc, broker, trader, transactions);
					break;
				
				case 2: 
					brokerFunctionality(sc, broker, trader, transactions);
					break;
					
				case 3: 
					brokerSignup(sc, broker);
					break;
					
				case 4: 
					traderFunctionality(sc, broker, trader, transactions);
					break;
					
				case 5: 
					traderSignup(sc, broker);
					break;
					
				case 0: 
					System.out.println("successfully existed from the system");
					break;
					
				default:
					throw new IllegalArgumentException("Invalid Selection");
				}
		
			}
			while(preference!=0);
			
			
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
