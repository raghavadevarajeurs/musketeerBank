package com.learning.onlinebank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.learning.onlinebank.model.Account;
import com.learning.onlinebank.model.CheckingAccount;
import com.learning.onlinebank.model.SavingsAccount;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
       
    	Account acct = null;
    	
    	if(rs.getString("accountType").equals("Savings")){
    		acct = new SavingsAccount();
    		
    		acct.setBalance(rs.getDouble("balance"));
    		acct.setMinBalance(rs.getDouble("minBalance"));
    		acct.setCreatedDate(rs.getString("createdDate"));
    		
    		
    	} else if(rs.getString("accountType").equals("Checkings")){
    		acct = new CheckingAccount();
    		
    		acct.setBalance(rs.getDouble("balance"));
    		acct.setMinBalance(rs.getDouble("minBalance"));
    		acct.setCreatedDate(rs.getString("createdDate"));
    	}

    	return acct;
    }
}