package com.sjsu.musketeerbank.model;


public class CheckingAccount extends Account {


public CheckingAccount(int accountNumber)
{
	super(accountNumber);
}

public CheckingAccount() {
	
}

public int getAccountNumber()
{
	return accountNumber;
}

public double getBalance()
{
	return balance;
}


public String getAccountInfo()
{
	return("Checking Account Information\nAcct Num: " + getAccountNumber() + "\nBalance: " + getBalance());
}
  }
