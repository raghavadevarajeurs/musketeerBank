package com.sjsu.musketeerbank.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sjsu.musketeerbank.model.Transfer;

@Repository
public class TransferDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransferDAO.class);
	
	public int createTransfer(Transfer tranfObj) {
		try {
			String INSERT_QUERY = "INSERT INTO TransferAmounts (transfertype,fromAccountNumber,toAccountNumber,amount,desciption,transferDate,recurrtype,recurrDate,createdby) VALUES (?,?,?,?,?,?,?,?,?)";
			 java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			return jdbcTemplate.update(INSERT_QUERY,tranfObj.getTransfertype(), tranfObj.getFromAccountNumber(), tranfObj.getToAccountNumber(), tranfObj.getAmount(),tranfObj.getDesciption(),date,tranfObj.getRecurrtype(),tranfObj.getRecurrDate(),tranfObj.getCreatedby());
		} catch (Exception e) {
			System.out.println("Exception while createTransfer " + e);
			return 0;

		}

	}

}
