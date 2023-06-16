package com.stockguru.services;

import java.util.Collection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.exceptions.AccountException;
import com.stockguru.exceptions.StockException;

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
			List<Transaction> transactions) throws StockException, InvalidDetailsException {
		// TODO Auto-generated method stub
		
		if(!stock.containsKey(name)) {
			throw new StockException("Invalid Stock");
		}
		else {
			
			double buyingPrice = qty * stock.get(name).getPrice();
			
			if (trader.get(username).getWalletAmount()> buyingPrice) {
				trader.get(username).setWalletAmount(trader.get(username).getWalletAmount()-buyingPrice);

			

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
		
	

}
