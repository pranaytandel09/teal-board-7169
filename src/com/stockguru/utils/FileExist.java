package com.stockguru.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.ArrayList;

import com.stockguru.entity.Broker;
import com.stockguru.entity.Stock;
import com.stockguru.entity.Trader;
import com.stockguru.entity.Transaction;

import java.util.LinkedHashMap;
import java.util.List;

public class FileExist {

	public static Map<String, Broker> brokerFile(){
		
		Map<String, Broker> bFile= null;
		File f= new File("Broker.ser");
		boolean flag= false;
		try {
		
		if(!f.exists()) {
			
			f.createNewFile();
			flag= true;
		}
		if(flag) {
			bFile= new LinkedHashMap<>();
			ObjectOutputStream boos= new ObjectOutputStream(new FileOutputStream(f));
			boos.writeObject(bFile);
			return bFile;
		}
		else {
			ObjectInputStream bois= new ObjectInputStream(new FileInputStream(f));
			bFile= (Map<String, Broker>) bois.readObject();
			return bFile;
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return bFile;
	}
	
public static Map<String, Trader> traderFile(){
		
		Map<String, Trader> tFile= null;
		File f= new File("trader.ser");
		boolean flag= false;
		try {
		
		if(!f.exists()) {
			
			f.createNewFile();
			flag= true;
		}
		if(flag) {
			tFile= new LinkedHashMap<>();
			ObjectOutputStream toos= new ObjectOutputStream(new FileOutputStream(f));
			toos.writeObject(tFile);
			return tFile;
		}
		else {
			ObjectInputStream tois= new ObjectInputStream(new FileInputStream(f));
			tFile= (Map<String, Trader>) tois.readObject();
			return tFile;
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return tFile;
	}

public static List<Transaction> transactionFile(){
	
	List<Transaction> transFile= new ArrayList<>();
	File f= new File("Transaction.ser");
	boolean flag= false;
	try {
	
	if(!f.exists()) {
		
		f.createNewFile();
		flag= true;
	}
	if(flag) {
		transFile= new ArrayList<>();
		ObjectOutputStream boos= new ObjectOutputStream(new FileOutputStream(f));
		boos.writeObject(transFile);
		return transFile;
	}
	else {
		ObjectInputStream bois= new ObjectInputStream(new FileInputStream(f));
		transFile= (List<Transaction>) bois.readObject();
		return transFile;
	}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return transFile;
}

public static Map<String, Stock> stockFile(){
	

	
	        // Create a map to store the stocks
	        Map<String, Stock> stockMap = new LinkedHashMap<>();

	        // Create Stock objects and add them to the map
	        Stock stock1 = new Stock("TCS", 250);
	        stockMap.put(stock1.getName(), stock1);

	        Stock stock2 = new Stock("INF", 150);
	        stockMap.put(stock2.getName(), stock2);

	        Stock stock3 = new Stock("REL", 200);
	        stockMap.put(stock3.getName(), stock3);

	        // Add more stocks to the map
	        Stock stock4 = new Stock("HDF", 180);
	        stockMap.put(stock4.getName(), stock4);

	        Stock stock5 = new Stock("WIP", 120);
	        stockMap.put(stock5.getName(), stock5);

	        Stock stock6 = new Stock("ITC", 90);
	        stockMap.put(stock6.getName(), stock6);

	        Stock stock7 = new Stock("BAJ", 300);
	        stockMap.put(stock7.getName(), stock7);

	        Stock stock8 = new Stock("TAT", 170);
	        stockMap.put(stock8.getName(), stock8);

	        Stock stock9 = new Stock("ACC", 220);
	        stockMap.put(stock9.getName(), stock9);

	        Stock stock10 = new Stock("INF", 130);
	        stockMap.put(stock10.getName(), stock10);

	        Stock stock11 = new Stock("MAR", 280);
	        stockMap.put(stock11.getName(), stock11);

	        Stock stock12 = new Stock("LAR", 190);
	        stockMap.put(stock12.getName(), stock12);

	        Stock stock13 = new Stock("ICI", 210);
	        stockMap.put(stock13.getName(), stock13);

	        Stock stock14 = new Stock("COA", 100);
	        stockMap.put(stock14.getName(), stock14);

	        Stock stock15 = new Stock("HCL", 240);
	        stockMap.put(stock15.getName(), stock15);
	        
	
	File f= new File("stock.ser");
	boolean flag= false;
	try {
	
	if(!f.exists()) {
		
		f.createNewFile();
		flag= true;
	}
	if(flag) {
		
		ObjectOutputStream toos= new ObjectOutputStream(new FileOutputStream(f));
		toos.writeObject(stockMap);
		return stockMap;
	}
	else {
		ObjectInputStream tois= new ObjectInputStream(new FileInputStream(f));
		stockMap= (Map<String, Stock>) tois.readObject();
		return stockMap;
	}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return stockMap;
}

}
