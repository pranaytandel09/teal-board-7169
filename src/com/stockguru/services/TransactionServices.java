package com.stockguru.services;

import java.util.List;

import com.stockguru.entity.Transaction;
import com.stockguru.exceptions.TransactionException;

public interface TransactionServices {

	public void traderTransactions(String username, List<Transaction> transactions) throws TransactionException;

	public void viewAllTransaction(List<Transaction> transactions) throws TransactionException;

}
