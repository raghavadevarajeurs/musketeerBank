package com.sjsu.musketeerbank.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sjsu.musketeerbank.model.Transaction;

@Repository
public class TransactionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionDAO.class);
	
	public int createTransaction(Transaction transObj) {
		try {
			String INSERT_QUERY = "INSERT INTO Transactions (transactionType,amount,balance,description,transactionDate,accountNumber,createdBy) VALUES (?,?,?,?,?,?,?)";
			 java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			return jdbcTemplate.update(INSERT_QUERY,transObj.getTransactionType(), transObj.getAmount(), transObj.getBalance(), transObj.getDescription(),date,transObj.getAccountNumber(),transObj.getCreatedBy());
		} catch (Exception e) {
			System.out.println("Exception while Transaction form" + e);
			return 0;

		}

	}

}
