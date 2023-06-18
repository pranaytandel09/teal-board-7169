package com.stockguru;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.exceptions.InvalidDetailsException;
import com.stockguru.exceptions.StockException;
import com.stockguru.exceptions.TransactionException;
import com.stockguru.exceptions.AccountException;

import com.stockguru.entity.Admin;
import com.stockguru.entity.Broker;
import com.stockguru.entity.Stock;
import com.stockguru.entity.Trader;
import com.stockguru.entity.Transaction;
import com.stockguru.services.*;
import com.stockguru.utils.FileExist;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void adminFunctionality(Scanner sc, Map<String, Broker> broker, Map<String, Trader> trader, List<Transaction> transactions)
	throws InvalidDetailsException{
		
		AdminServices adminService= new AdminServicesImpl();
		BrokerServices brokerService = new BrokerServicesImpl();
		TraderServices traderServices= new TraderServicesImpl();
		TransactionServices transactionService= new TransactionServicesImpl();
		
		adminLogin(sc);
		
		int choice=0;
		try {
			
			do {

				System.out.println("Press 1 view all broker's accounts");
				System.out.println("Press 2 view all trader's accounts");
				System.out.println("Press 3 to view all transactions");
			
				System.out.println("Press 4 to log out");
				choice = sc.nextInt();

				switch (choice) {
	
				case 1:

					ViewAllBrokerAcc(broker, brokerService);
					break;
				case 2:
					viewAllTradersAcc(trader, traderServices);
					break;
				case 3:

					viewOverallTransactions(transactions,transactionService);
					break;
//				case 4:
//                      viewfilterdTransactions(sc,transactions,transactionService);
//					break;
				case 5:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice < 5);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public static void adminLogin(Scanner sc) throws InvalidDetailsException {
		
		System.out.println("Please provide the admin credentials.");
		System.out.println("Enter UserName");
		String userName= sc.next();
		
		System.out.println("Enter Password");
		String passWord= sc.next();
		
		if (userName.equals(Admin.username) && passWord.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}
	
public static void ViewAllBrokerAcc(Map<String, Broker> broker, BrokerServices brokerService) {
	
	List<Broker> list;
	try {
		list = brokerService.viewAllBrokers(broker);
		for (Broker b : list) {
			System.out.println(b);
		}
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}

	
}
public static void brokerFunctionality(Scanner sc, Map<String, Broker> broker, Map<String, Trader> trader, List<Transaction> transactions) throws InvalidDetailsException, AccountException{
		
	AdminServices adminService= new AdminServicesImpl();
	BrokerServices brokerService = new BrokerServicesImpl();
	TraderServices traderServices= new TraderServicesImpl();
	TransactionServices transactionService= new TransactionServicesImpl();
	
	try {
		System.out.println("Please enter your preference, " + " '1' --> Broker login , '2' --> Broker signup ");
		int pref=0;
		pref=sc.nextInt();
		
		if(pref==1) {
			//BrokerLogin
			System.out.println("please enter the following details to login");
			System.out.println("please enter the username");
			String username = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
			BrokerLogin(username,pass, broker, brokerService);
			
			try {
				int choice = 0;
				do {
					System.out.println("Select the option of your choice");
					System.out.println("Press 1 to view all trader's account");
					System.out.println("Press 2 to view trader's porfolio");
					System.out.println("Press 3 to view transaction history");
					System.out.println("Press 4 view transaction history of perticular trader");
					System.out.println("Press 5 to logout");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						viewAllTradersAcc(trader,traderServices);
						break;
					case 2:
						adminViewTradersPortfolio(sc,transactions,traderServices,trader);
						break;
					case 3:
						viewOverallTransactions(transactions,transactionService);
						break;
					case 4:
                          adminViewTradersTransaction(sc,transactions, transactionService);
                          
						break;
					case 5:
						System.out.println("you have successsfully logout");
						break;
					default:
						System.out.println("invalid choice");
						break;
					}

				} while (choice < 5);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else if(pref==2){
			brokerSignup(sc, broker,brokerService);
//			System.out.println("successfully login.......");
		}
		else {
			throw new IllegalArgumentException("Invalid Selection");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	
	
	}
	
private static void adminViewTradersTransaction(Scanner sc, List<Transaction> transactions,
		TransactionServices transactionService) {
	// TODO Auto-generated method stub
	System.out.println("Enter trader's username");
	String username= sc.next();
	try {
		transactionService.traderTransactions(username,transactions);
	} catch (TransactionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void viewOverallTransactions(List<Transaction> transactions, TransactionServices transactionService) {
	// TODO Auto-generated method stub
	try {
		transactionService.viewAllTransaction(transactions);
	} catch (TransactionException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}

private static void adminViewTradersPortfolio(Scanner sc, List<Transaction> transactions,
		TraderServices traderServices, Map<String, Trader> trader)  {
	

	
	try {
		System.out.println("enter trader's username");
		String username= sc.next();
		if(trader.containsKey(username)) {
			traderPortfolio(username, transactions, traderServices);
		}
		else {
			throw new InvalidDetailsException("trader with given username not found");
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
}

private static void viewAllTradersAcc(Map<String, Trader> trader, TraderServices traderServices)  {
	// TODO Auto-generated method stub
	List<Trader> list;
	try {
		list = traderServices.viewAllAcc(trader);
		for(Trader t: list) {
			System.out.println(t);
		}
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());;
	}
	
	
}

private static void BrokerLogin(String username, String pass, Map<String, Broker> broker,
		BrokerServices brokerService) throws InvalidDetailsException {
	// TODO Auto-generated method stub
	
	brokerService.login(username, pass, broker);
	System.out.println("Broker has successfully login");
	
}

public static void brokerSignup(Scanner sc, Map<String, Broker> broker, BrokerServices brokerService) throws DuplicateDataException {

	brokerService.signUp(sc, broker);
	System.out.println("sign up Successful");
	
}

public static void traderFunctionality(Scanner sc, Map<String, Broker> broker, Map<String, Trader> trader, List<Transaction> transactions, Map<String, Stock> stock) throws InvalidDetailsException{
	
	BrokerServices brokerService = new BrokerServicesImpl();
	TraderServices traderServices= new TraderServicesImpl();
	TransactionServices transactionService= new TransactionServicesImpl();
	
	//TraderLogin
//	for(Transaction tr: transactions) {
//		System.out.println(tr);
//	}
	System.out.println(trader);
		System.out.println("please enter the following details to login");
		System.out.println("please enter the username");
		String username = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		
		TraderLogin(username,pass, trader, traderServices);
		
		try {
			int choice = 0;
			
			do {
				
				System.out.println("Select the option of your choice");
				System.out.println("Press 1 to view all stocks");
				System.out.println("Press 2 to buy a new stock");
				System.out.println("Press 3 sell a existing stock");
				System.out.println("Press 4 view wallet balance");
				System.out.println("Press 5 add wallet balance");
				System.out.println("Press 6 view my Portfolio");
				System.out.println("Press 7 view my transactions");
				System.out.println("Press 8 delete the account");
				System.out.println("Press 9 to logout");
				choice = sc.nextInt();
                       
				
				switch (choice) {
				case 1:
					viewAllStocks(traderServices ,stock);
					break;
				case 2:
					String result = traderBuyStock(sc, username, trader, stock, transactions, traderServices);
					System.out.println(result);
					break;
				case 3:
					traderSellStock(sc, username, trader, traderServices, transactions);
					
					break;
				case 4:
					double walletBalance = traderViewWalletBalance(username, trader, traderServices);
					System.out.println("Wallet balance is: " + walletBalance);
					break;
				case 5:
					String moneyAdded = traderAddMoneyToWallet(sc, username, trader, traderServices);
					System.out.println(moneyAdded);
					break;
				case 6:
					traderPortfolio(username, transactions, traderServices);
					break;
				case 7:
					traderViewTraderTransactions(username, transactions, transactionService);
					break;
				case 8:
					traderAccDeletion(username, trader, traderServices);
					break;
				case 9:
					System.out.println("you have successsfully logout");
					break;
				default:
					System.out.println("invalid choice");
					break;
				}
			

			} while (choice < 8);
	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			// serialization (finally always executed)
			try {
//				ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("trader.ser"));
//				toos.writeObject(trader);
//				ObjectOutputStream boos = new ObjectOutputStream(new FileOutputStream("Broker.ser"));
//				boos.writeObject(broker);

				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Transaction.ser"));
				oos.writeObject(transactions);
				
//				ObjectOutputStream soos = new ObjectOutputStream(new FileOutputStream("stock.ser"));
//				soos.writeObject(stock);
//				System.out.println("serialized..........");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	
}



private static void traderPortfolio(String username, List<Transaction> transactions, TraderServices traderServices) throws TransactionException {
	// TODO Auto-generated method stub
	traderServices.viewPortfolio(username, transactions);
	
}

private static void traderSellStock(Scanner sc, String username, Map<String, Trader> trader,
		TraderServices traderServices, List<Transaction> transactions) throws TransactionException {
	// TODO Auto-generated method stub
	
	traderServices.sellStock(sc, username, trader, transactions);
	
	
}

private static void traderAccDeletion(String username, Map<String, Trader> trader, TraderServices traderServices) {
	// TODO Auto-generated method stub
	
	traderServices.deleteAccount(username, trader);
}

private static void traderViewTraderTransactions(String username, List<Transaction> transactions,
		TransactionServices transactionService) throws TransactionException {
	// TODO Auto-generated method stub
	 transactionService.traderTransactions(username,transactions);
	
}

private static String traderAddMoneyToWallet(Scanner sc, String username, Map<String, Trader> trader,
		TraderServices traderServices) {
	// TODO Auto-generated method stub
	String str= traderServices.traderAddMoneyToWallet( sc, username, trader);
	return str;
}

private static double traderViewWalletBalance(String username, Map<String, Trader> trader,
		TraderServices traderServices) {
	// TODO Auto-generated method stub
	double amt= traderServices.viewWalletBalance(username,trader);
	return amt;
}

private static String traderBuyStock(Scanner sc, String username, Map<String, Trader> trader, Map<String, Stock> stock,
		List<Transaction> transactions, TraderServices traderServices) throws StockException, InvalidDetailsException {
	// TODO Auto-generated method stub
	
	System.out.println("Enter the stock name(eg.IBM)");
	String name = sc.next();
	System.out.println("enter the quantity you want to buy");
	int qty = sc.nextInt();
	traderServices.buyStock(name, qty, username, trader, stock, transactions);

	return "You have successfully bought the product";
	
}

private static void viewAllStocks(TraderServices traderServices, Map<String, Stock> stock) {
	// TODO Auto-generated method stub
	
	traderServices.viewAllStocks(stock);
	
}

private static void TraderLogin(String username, String pass, Map<String, Trader> trader,
		TraderServices traderServices) throws InvalidDetailsException {
	// TODO Auto-generated method stub
	
     
     traderServices.login(username, pass, trader);
	System.out.println("Trader has successfully login");
     
     
}

public static void traderSignup(Scanner sc, Map<String, Trader> trader) throws DuplicateDataException {
	
	System.out.println("please enter the following details to Signup for trader's account");
	System.out.println("please enter the user name");
	String name = sc.next();
	System.out.println("Enter the password");
	String pass = sc.next();

	System.out.println("Enter the email id");
	String email = sc.next();
	System.out.println("Enter the age");
	int age = sc.nextInt();
	System.out.println("Enter the balance to be added into the wallet");
	double balance = sc.nextDouble();
	
	Trader trd = new Trader(name, pass, age, balance, email);

	TraderServices traderServices= new TraderServicesImpl();
	traderServices.signUp(trd, trader);
	System.out.println("customer has Succefully sign up");
	
}

	public static void main(String[] args) {
		
		//file check
				Map<String, Broker> broker = FileExist.brokerFile();
				Map<String, Trader> trader = FileExist.traderFile();
				List<Transaction> transactions = FileExist.transactionFile();
				Map<String, Stock> stock = FileExist.stockFile();
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to Trader's Mart...");
		
		int preference=0;
		try {
		
			do {
				

				
				
//				System.out.println(broker.size());
//				System.out.println(trader.size());
//				System.out.println(transactions.size());
				
				System.out.println("Please enter your preference \n, " + " '1' --> Admin login \n , '2' --> Broker login , \n"
						+ "'3' --> Broker signup, \n '4' --> Trader Login,\n  '5' --> Trader Signup,\n  '0' --> exit ");
				 preference= sc.nextInt();
				try {
					
					switch(preference) {
					
					case 1: 
						adminFunctionality(sc, broker, trader, transactions);
						break;
					
					case 2: 
						brokerFunctionality(sc, broker, trader, transactions);
						break;
						
//					case 3: 
//						brokerSignup(sc, broker);
//						break;
						
					case 4: 
						traderFunctionality(sc, broker, trader, transactions, stock);
						break;
						
					case 5: 
						traderSignup(sc, trader);
						break;
						
					case 0: 
						System.out.println("successfully existed from the system");
						break;
						
					default:
						throw new IllegalArgumentException("Invalid Selection");
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
		
			}
			while(preference!=0);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			// serialization (finally always executed)
			try {
				ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("trader.ser"));
				toos.writeObject(trader);
				ObjectOutputStream boos = new ObjectOutputStream(new FileOutputStream("Broker.ser"));
				boos.writeObject(broker);

				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Transaction.ser"));
				oos.writeObject(transactions);
				
				ObjectOutputStream soos = new ObjectOutputStream(new FileOutputStream("stock.ser"));
				soos.writeObject(stock);
				System.out.println("serialized..........");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
}
