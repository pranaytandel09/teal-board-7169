package com.stockguru.exceptions;

public class StockException extends Exception{

	public StockException(){
		super();
	}
	
	public StockException(String msg){
		super(msg);
	}
}
