package com.stockguru.exceptions;

public class TransactionException extends Exception{

	public TransactionException(){
		super();
	}
	
	public TransactionException(String msg){
		super(msg);
	}
}
