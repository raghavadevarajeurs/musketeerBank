package com.sjsu.musketeerbank.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sjsu.musketeerbank.model.*;

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
	
	

}
