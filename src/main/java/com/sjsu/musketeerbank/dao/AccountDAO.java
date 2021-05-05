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

import com.sjsu.musketeerbank.model.Account;
import com.sjsu.musketeerbank.model.User;
import com.sjsu.musketeerbank.model.UserAccount;
import com.sjsu.musketeerbank.repository.AccountRowMapper;
import com.sjsu.musketeerbank.repository.UserAccountRowMapper;

@Repository
public class AccountDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAO.class);
	
	public List<Account> getUserAccountDetails(String userName) {
		DataSource dataSource;
		Connection connection = null;
		String selectquery="";
		List<Account> accounts = new ArrayList<>();

		if(userName !=null){
			selectquery = "select * from Account where userId = (select userId from Users where userName= '"+userName+"')";
		}		

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			/*Account acct = (Account)jdbcTemplate.queryForObject(
					  selectquery, new Object[] { userName }, new AccountRowMapper());*/
			
			accounts = jdbcTemplate.query(selectquery, new AccountRowMapper());
			
			//public Account(Integer.parseInt(rs.getString("accountNumber")), rs.getDouble("balance"), rs.getDouble("minBalance"), rs.getString("createdDate"), rs.getString("accountType")) 
			

		} catch (EmptyResultDataAccessException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getting  employees info.", e);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getting employees info.", e);

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);

				// e.printStackTrace();
			}
		}

		//return user;
		return accounts;
	}
	
	public List<UserAccount> getAllAccountDetails() {
		DataSource dataSource;
		Connection connection = null;
		String selectquery="";
		List<UserAccount> accounts = new ArrayList<>();

			selectquery = "SELECT user.userID, user.userName, acct.accountNumber, acct.accountType, acct.balance"
					+ "  FROM bankdb.Account acct, bankdb.Users user"
					+ " where acct.userID = user.userID";
			

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			accounts = jdbcTemplate.query(selectquery, new UserAccountRowMapper());
			

		} catch (EmptyResultDataAccessException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getting  employees info.", e);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getting employees info.", e);

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);

			}
		}

		//return user;
		return accounts;
	}
	
	public int createAccount(Account acctObj, String userId) {
		try {
			String INSERT_QUERY = "INSERT INTO Account (accountNumber,accountType,balance,minBalance,userID,createdDate) VALUES (?,?,?,?,?,sysdate())";

			return jdbcTemplate.update(INSERT_QUERY,acctObj.getAccountNumber(), acctObj.getAccountType(), acctObj.getBalance(), acctObj.getMinBalance(), userId);
		} catch (Exception e) {
			System.out.println("Exception while submitting leave" + e);
			return 0;

		}
		//return 0;

	}
	
	public int createAccountNew(User userObj,String userid) {
		try {
			String INSERT_QUERY = "INSERT INTO Account (accountType,balance,minBalance,userID,createdDate) VALUES (?,?,?,?,?)";
       
             java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			return jdbcTemplate.update(INSERT_QUERY, userObj.getAccountType(), userObj.getBalance(), userObj.getMinBalance(),userid,date);
		} catch (Exception e) {
			System.out.println("Exception while Creating Account" + e);
			return 0;

		}

	}
	
	public String getaccountID(String userid) {
		try {
			String Select_QUERY = "SELECT accountID FROM Account where userID=? ORDER BY accountID DESC LIMIT 1;";
		   return (String)jdbcTemplate.queryForObject(Select_QUERY,new Object[] {userid},String.class);
		} catch (Exception e) {
			System.out.println("Exception while Reg form" + e);
			return "Error";

		}

	}
	
	public int updateAccountNew(String accountid,int accountno) {
		try {
			String update_QUERY = "update Account set accountNumber=? where accountID=?";
     
             java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			return jdbcTemplate.update(update_QUERY,accountno, accountid);
		} catch (Exception e) {
			System.out.println("Exception while update Account" + e);
			return 0;

		}

	}

}
