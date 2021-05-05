package com.sjsu.musketeerbank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sjsu.musketeerbank.model.Account;
import com.sjsu.musketeerbank.model.CheckingAccount;
import com.sjsu.musketeerbank.model.SavingsAccount;
import com.sjsu.musketeerbank.model.UserAccount;

public class UserAccountRowMapper implements RowMapper<UserAccount> {
    @Override
    public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
       
    	UserAccount acct = new UserAccount();
    	
    	if (rs!=null){
    		
    		acct.setAccountNumber(rs.getString("accountNumber"));
    		acct.setAccountType(rs.getString("accountType"));
    		acct.setBalance(rs.getDouble("balance"));
    		acct.setUserId(rs.getString("userID"));
    		acct.setUserName(rs.getString("userName"));
    	}

    	return acct;
    }
}