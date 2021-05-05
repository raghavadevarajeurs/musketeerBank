package com.sjsu.musketeerbank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sjsu.musketeerbank.model.Registration;

public class RegistrationRowMapper implements RowMapper<Registration> {
    @Override
    public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
       
    	Registration reg = new Registration();
    	
    	if (rs!=null){
    		
    		//firstName,lastName,age,address,accountType,occupation,email,phone,regstatus
    		reg.setAccountType(rs.getString("accountType"));
    		reg.setAddress(rs.getString("address"));
    		reg.setAge(rs.getInt("age"));
    		reg.setEmail(rs.getString("email"));
    		reg.setFirstName(rs.getString("firstName"));
    		reg.setLastName(rs.getString("lastName"));
    		reg.setOccupation(rs.getString("occupation"));
    		reg.setPhone(rs.getString("phone"));
    		reg.setRegid(""+rs.getInt("regid"));
    		reg.setRegstatus(rs.getString("regstatus"));
    		
    	}

    	return reg;
    }
}