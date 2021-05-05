package com.sjsu.musketeerbank.model;

public class Transfer {
	
private int transferid;
private String transfertype;
private String fromAccountNumber;
private String toAccountNumber;
private double amount;
private String desciption;
public int getTransferid() {
	return transferid;
}
public void setTransferid(int transferid) {
	this.transferid = transferid;
}
public String getTransfertype() {
	return transfertype;
}
public void setTransfertype(String transfertype) {
	this.transfertype = transfertype;
}
public String getFromAccountNumber() {
	return fromAccountNumber;
}
public void setFromAccountNumber(String fromAccountNumber) {
	this.fromAccountNumber = fromAccountNumber;
}
public String getToAccountNumber() {
	return toAccountNumber;
}
public void setToAccountNumber(String toAccountNumber) {
	this.toAccountNumber = toAccountNumber;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getDesciption() {
	return desciption;
}
public void setDesciption(String desciption) {
	this.desciption = desciption;
}
public String getRecurrtype() {
	return recurrtype;
}
public void setRecurrtype(String recurrtype) {
	this.recurrtype = recurrtype;
}
public String getRecurrDate() {
	return recurrDate;
}
public void setRecurrDate(String recurrDate) {
	this.recurrDate = recurrDate;
}
public String getCreatedby() {
	return createdby;
}
public void setCreatedby(String createdby) {
	this.createdby = createdby;
}
private String recurrtype;
private String recurrDate;
private String createdby;

}
