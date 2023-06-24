package com.stockguru.services;

import java.util.Collection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.exceptions.AccountException;
import com.stockguru.exceptions.StockException;
import com.stockguru.exceptions.TransactionException;
import com.stockguru.utils.SellingPriceGenerator;
import com.stockguru.entity.Portfolio;
import com.stockguru.entity.Stock;
import com.stockguru.entity.Trader;
import com.stockguru.entity.Transaction;
import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.exceptions.InvalidDetailsException;

public class TraderServicesImpl implements TraderServices{

	@Override
	public boolean login(String username, String pass, Map<String, Trader> trader) throws InvalidDetailsException {
		// TODO Auto-generated method stub
if (trader.containsKey(username) ) {
			
			if(trader.get(username).getPassword().equals(pass)) {

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
	public void signUp(Trader trd, Map<String, Trader> trader) throws DuplicateDataException {
		// TODO Auto-generated method stub
		
	if (trader.containsKey(trd.getUsername())) {
			
			throw new DuplicateDataException("Customer already exists , please login");
			
		} else {

			trader.put(trd.getUsername(), trd);

		}
	}

	@Override
	public List<Trader> viewAllAcc(Map<String, Trader> trader) throws AccountException {
		// TODO Auto-generated method stub
		List<Trader>list=null;
		
		if(trader!=null && trader.size()>0) {
			
			Collection<Trader> col= trader.values();
			list= new ArrayList<>(col);
			
		}else {
			throw new AccountException("Trader account list is empty");
		}
		
		
		return list;
	}

	@Override
	public void viewAllStocks(Map<String, Stock> stock) {
		// TODO Auto-generated method stub
		
		Collection <Stock> col= stock.values();
		
		for(Stock s: col) {
			System.out.println(s);
		}
	}

	@Override
	public void buyStock(String name, int qty, String username, Map<String, Trader> trader, Map<String, Stock> stock,
			List<Transaction> transactions,  List<Portfolio> pof) throws StockException, InvalidDetailsException {
		// TODO Auto-generated method stub
		
		if(!stock.containsKey(name)) {
			throw new StockException("Invalid Stock");
		}
		else {
			
			double buyingPrice = qty * stock.get(name).getPrice();
			
			if (trader.get(username).getWalletAmount()> buyingPrice) {
				trader.get(username).setWalletAmount(trader.get(username).getWalletAmount()-buyingPrice);

//			if(pof.size()==0) {
//				Portfolio pf= new Portfolio(name, username, qty, buyingPrice);
//				pof.add(pf);
//			}else {
//				for(int i=0; i<pof.size(); i++) {
//					if(pof.get(i).getUsername().equals(username)) {
//						
//						if(pof.get(i).getName().equals(name)) {
//							
//							int q= pof.get(i).getQuantity() + qty;
//							double dp= q * stock.get(name).getPrice();
//							pof.set(i, new Portfolio(name, username, q, dp));
//							
//						}
//						else {
//							Portfolio pf= new Portfolio(name, username, qty, buyingPrice);
//							pof.add(pf);
//						
//						}
//						
//					}else {
//						Portfolio pf= new Portfolio(name, username, qty, buyingPrice);
//						pof.add(pf);
//						
//					}
//					
//				}
//			}

				Transaction tr = new Transaction(name, username, trader.get(username).getEmail(),buyingPrice, qty, LocalDate.now());

				transactions.add(tr);

			} else {
				throw new InvalidDetailsException("wallet balance is not sufficient");
			}
		}
		
	}

	@Override
	public double viewWalletBalance(String username, Map<String, Trader> trader) {
		// TODO Auto-generated method stub
		
		Trader trd= trader.get(username);
		return trd.getWalletAmount();
		
	}

	@Override
	public String traderAddMoneyToWallet(Scanner sc, String username, Map<String, Trader> trader) {
		// TODO Auto-generated method stub

		Trader trd = trader.get(username);
		
		System.out.println("Enter the amount to be added");
		double amt= sc.nextDouble();

		trd.setWalletAmount(trd.getWalletAmount() + amt);

		trader.put(username, trd);

		return amt+" amount added successfully";
		
	}

	@Override
	public void deleteAccount(String username, Map<String, Trader> trader) {
		// TODO Auto-generated method stub
		 
	trader.remove(username);
	System.out.println("Account deleted...");
	}

	@Override
	public void sellStock(Scanner sc, String username, Map<String, Trader> trader, List<Transaction> transactions) throws TransactionException {
		// TODO Auto-generated method stub
		System.out.println("Enter the name of stock");
		String name= sc.next();
		System.out.println("Enter the Quantity");
		int qty= sc.nextInt(); 
		
		double buyPrice=0;
		boolean flag = false;
		for (Transaction tr : transactions) {
			if (tr.getUsername().equals(username)) {

				if(tr.getName().equals(name)) {
					
					buyPrice+= tr.getBuyingPrice();
					flag=true;
				}
				
			}
		}
		if (!flag) {
			throw new TransactionException("No stock in portfolio...");
		}
		
		SellingPriceGenerator generate= new SellingPriceGenerator();

           double sp= SellingPriceGenerator.generatePrice();
           
           if(sp%2==0  ) {
        	   trader.get(username).setWalletAmount(trader.get(username).getWalletAmount()-sp);
        	   System.out.println("Stock sold successfully, had loss of: "+sp);
           }
           else {
        	   trader.get(username).setWalletAmount(trader.get(username).getWalletAmount()+sp);
        	   System.out.println("Stock sold successfully, had profit of: "+sp);
           }
			
           Transaction tr = new Transaction(name, username, trader.get(username).getEmail(),buyPrice, qty, buyPrice+sp, LocalDate.now());
           
          				transactions.add(tr);
           
             
	}
		
	

	@Override
	public void viewPortfolio(String username, List<Transaction> transactions,List<Portfolio> pof) throws TransactionException {
		// TODO Auto-generated method stub
		

		boolean flag = false;
		for (Transaction tr : transactions) {
			if (tr.getUsername().equals(username)) {

				System.out.println("Stock: "+tr.getName() +"  Qty: "+tr.getQuantity() +"  Amount: "+(tr.getBuyingPrice()));

				flag = true;
			}
		}
		if (!flag) {
			throw new TransactionException("porfolio is empty...");
		}
//		for (Portfolio tr : pof) {
//			if (tr.getUsername().equals(username)) {
//
//				System.out.println("Stock: "+tr.getName() +"  Qty: "+tr.getQuantity() +"  Amount: "+(tr.getBuyingPrice()));
//
//				flag = true;
//			}
//		}
//		if (!flag) {
//			throw new TransactionException("porfolio is empty...");
//		}

		
	}
		
	

}
