package com.sjsu.musketeerbank.model;

public class User {

	private String userId; 
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userType;
	private String phone;
	private String accountType;
	private String balance;
	public User(String userName, String userType) {
		super();
		this.userName = userName;
		this.userType = userType;
	}
	private String minBalance;

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(String minBalance) {
		this.minBalance = minBalance;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User(int i, String userName, String firstName, String lastName, String email, String password,
			String userType, String phone) {
		super();
		this.userId = ""+i;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.phone = phone;
	}
	public User() {
		super();
	}
	
	
	
}