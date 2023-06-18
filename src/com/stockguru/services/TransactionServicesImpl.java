package com.stockguru.services;

import java.util.ArrayList;
import java.util.List;


import com.stockguru.entity.Transaction;
import com.stockguru.exceptions.TransactionException;

public class TransactionServicesImpl implements TransactionServices{

	@Override
	public void traderTransactions(String username, List<Transaction> transactions) throws TransactionException {
		// TODO Auto-generated method stub
		
		List<Transaction> myTransactions = new ArrayList<>();

		boolean flag = false;
		for (Transaction tr : transactions) {
			if (tr.getUsername().equals(username)) {

				myTransactions.add(tr);

				flag = true;
			}
		}
		if (!flag) {
			throw new TransactionException("you have not done any transaction yet");
		}

		 for(Transaction tr:myTransactions) {
			 System.out.println(tr);
		 }
		
	}

	@Override
	public void viewAllTransaction(List<Transaction> transactions) throws TransactionException {
		// TODO Auto-generated method stub
		
		if(transactions.size()==0) {
			throw new TransactionException("you have not done any transaction yet");
		}
		else {
			
			transactions.sort((o1, o2) ->
			o1.getUsername().compareTo(o2.getUsername()));
			
			for(Transaction t: transactions) {
				System.out.println(t);
			}
		}
	}

}
