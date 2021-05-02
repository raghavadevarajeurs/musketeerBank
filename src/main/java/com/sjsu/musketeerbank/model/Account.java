package com.sjsu.musketeerbank.model;


public abstract class Account
{
	protected int accountNumber;
	protected double balance;
	protected double minBalance;
	private String createdDate;
	private String accountType;	
	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public Account() {
		super();
	}

	public Account(int acctNum)
	{
		accountNumber = acctNum;
		setBalance(0.0);
	}
	
	public void setBalance(double b)
	{
		balance = b;
	}
	
	public abstract int getAccountNumber();
	public abstract double getBalance();
	
	// Added this because it makes sense with my current application design
	public abstract String getAccountInfo();
	
	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}
}
