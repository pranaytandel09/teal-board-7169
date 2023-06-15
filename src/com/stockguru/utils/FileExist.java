package com.stockguru.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.ArrayList;

import com.stockguru.entity.Broker;
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
	
	List<Transaction> transFile= null;
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
}
