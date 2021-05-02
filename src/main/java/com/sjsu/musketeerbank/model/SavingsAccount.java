package com.sjsu.musketeerbank.model;

public class SavingsAccount extends Account {
	private double interestRate;

	private double balance;
	private double interest;

	public SavingsAccount() {
		balance = 0;
		interest = 0;
	}

	public SavingsAccount(int accountNumber, double interest) {
		super(accountNumber);
		setInterestRate(interest);
	}

	public void setInterestRate(double interest) {
		interestRate = interest;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountInfo() {
		return ("Savings Account Information\nAccount Number: " + getAccountNumber() + "\nBalance: " + getBalance()
				+ "\nInterest Rate: " + getInterestRate() + "%");
	}

	public void addInterest() {
		balance = balance + balance * interest;
	}

}

