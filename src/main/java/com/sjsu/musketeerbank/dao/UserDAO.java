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

import com.sjsu.musketeerbank.model.User;
import com.sjsu.musketeerbank.repository.UserRowMapper;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

	public List<User> getAllUsers() {

		DataSource dataSource;
		Connection connection = null;
		List<User> userDetails = new ArrayList<>();

		String selectquery = "select * from Users";

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			userDetails = jdbcTemplate.query(selectquery,
					(rs, rowNum) -> new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("firstName"),
							rs.getString("lastName"), rs.getString("email"), rs.getString("password"),
							rs.getString("userType"),rs.getString("phone")));

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

		return userDetails;

	}

	public List getAllCustomerNames() {

		DataSource dataSource;
		Connection connection = null;
		List userNames = new ArrayList<>();

		String selectquery = "select userName, userType from Users where userType = 'User'";

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			userNames = jdbcTemplate.query(selectquery,
					(rs, rowNum) -> new User(rs.getString("userName"), rs.getString("userType")));

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

		return userNames;

	}
	
	public int createUser(User userObj) {
		try {
			String INSERT_QUERY = "INSERT INTO Users (userName,userType,firstName,lastName,email,password,phone) VALUES (?,?,?,?,?,?,?)";

			return jdbcTemplate.update(INSERT_QUERY,userObj.getUserName(), userObj.getUserType(), userObj.getFirstName(), userObj.getLastName(),userObj.getEmail(),userObj.getPassword(), userObj.getPhone() );
		} catch (Exception e) {
			System.out.println("Exception while creating new user" + e);
			return 0;

		}

	}

	public User checkUserExists(User userObj) {
		DataSource dataSource;
		Connection connection = null;
		String selectquery="";
		User user = new User();
		String userId = "0";
		String selectNewquery = null;

		if(userObj.getUserName() !=null){
			selectquery = "select count(*) from Users where userName= ?";
			selectNewquery = "select * from Users where userName= ?";
		}
		

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			int count=jdbcTemplate.queryForObject(selectquery,new Object[] {userObj.getUserName()},Integer.class);
			System.out.println("count>> "+count);
					if(count>0)
					{
					user = (User)  jdbcTemplate.queryForObject(
							selectNewquery, new Object[] { userObj.getUserName() }, new UserRowMapper());
					}

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

		return user;
	}
	
	public User loginUser(User userObj) {
		DataSource dataSource;
		Connection connection = null;
		String selectquery="";
		User user = new User();

		if(userObj.getUserName() !=null){
			selectquery = "select * from Users where userName= ? and password = ?";
		}		

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			user = (User)  jdbcTemplate.queryForObject(
					  selectquery, new Object[] { userObj.getUserName(), userObj.getPassword() }, new UserRowMapper());

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

		return user;
	}


}
