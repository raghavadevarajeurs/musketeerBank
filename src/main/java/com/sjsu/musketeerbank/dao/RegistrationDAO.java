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

import com.sjsu.musketeerbank.model.Registration;
import com.sjsu.musketeerbank.model.User;
import com.sjsu.musketeerbank.repository.AccountRowMapper;
import com.sjsu.musketeerbank.repository.RegistrationRowMapper;

@Repository
public class RegistrationDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationDAO.class);
	
	public int registrationForm(Registration regObj) {
		try {
			String INSERT_QUERY = "INSERT INTO Registration (firstName,lastName,age,address,accountType,occupation,email,phone,regstatus) VALUES (?,?,?,?,?,?,?,?,?)";

			return jdbcTemplate.update(INSERT_QUERY,regObj.getFirstName(), regObj.getLastName(), regObj.getAge(), regObj.getAddress(),regObj.getAccountType(),regObj.getOccupation(), regObj.getEmail(),regObj.getPhone(),regObj.getRegstatus());
		} catch (Exception e) {
			System.out.println("Exception while Reg form" + e);
			return 0;

		}

	}
	
	public List<Registration> getAddAccountRequests() {

		DataSource dataSource;
		Connection connection = null;
		List<Registration> regDetails = new ArrayList<>();

		String selectquery = "SELECT * FROM bankdb.Registration where regstatus = 'Pending'";

		try {
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if (null == dataSource) {

			}

			connection = dataSource.getConnection();

			if (null == connection) {

			}

			regDetails = jdbcTemplate.query(selectquery, new RegistrationRowMapper());

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

		return regDetails;

	}
	
	

}
