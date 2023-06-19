package com.stockguru.services;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.stockguru.entity.Portfolio;
import com.stockguru.entity.Stock;
import com.stockguru.entity.Trader;
import com.stockguru.entity.Transaction;
import com.stockguru.exceptions.DuplicateDataException;
import com.stockguru.exceptions.InvalidDetailsException;
import com.stockguru.exceptions.StockException;
import com.stockguru.exceptions.TransactionException;
import com.stockguru.exceptions.AccountException;

public interface TraderServices {

	public boolean login(String username, String pass, Map<String, Trader> trader) throws InvalidDetailsException;

	public void signUp(Trader trd, Map<String, Trader> trader) throws DuplicateDataException;

	public List<Trader> viewAllAcc(Map<String, Trader> trader) throws AccountException;

	public void viewAllStocks(Map<String, Stock> stock);

	public void buyStock(String name, int qty, String username, Map<String, Trader> trader, Map<String, Stock> stock,
			List<Transaction> transactions, List<Portfolio> pof) throws StockException, InvalidDetailsException;

	public double viewWalletBalance(String username, Map<String, Trader> trader);

	public String traderAddMoneyToWallet(Scanner sc, String username, Map<String, Trader> trader);

	public void deleteAccount(String username, Map<String, Trader> trader);

	public void sellStock(Scanner sc, String username, Map<String, Trader> trader, List<Transaction> transactions) throws TransactionException;

	public void viewPortfolio(String username, List<Transaction> transactions, List<Portfolio> pof) throws TransactionException;

	

}
