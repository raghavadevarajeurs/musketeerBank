package com.sjsu.musketeerbank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sjsu.musketeerbank.model.Account;
import com.sjsu.musketeerbank.model.CheckingAccount;
import com.sjsu.musketeerbank.model.SavingsAccount;

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