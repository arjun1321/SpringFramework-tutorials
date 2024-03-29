package com.arjunkumar.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.arjunkumar.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	// add a new method for findAccounts
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// simulate the exception
		if(tripWire) {
			throw new RuntimeException();
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		
		Account temp1 = new Account("Arjun", "Platinum");
		Account temp2 = new Account("Rahul", "Gold");
		Account temp3 = new Account("Anuj", "Silver");
		
		// add accounts to list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		
		return false;
	}


	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
}
