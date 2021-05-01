package com.learning.onlinebank.model;

import java.util.List;

public class UserAccount {

	private String userId; 
	private List<Account> accounts;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
