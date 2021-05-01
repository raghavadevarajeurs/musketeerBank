package com.learning.onlinebank.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.onlinebank.dao.RegistrationDAO;
import com.learning.onlinebank.dao.UserDAO;
import com.learning.onlinebank.model.Registration;
import com.learning.onlinebank.model.User;


@Controller
public class RegistrationController {
	

	@Autowired
	private RegistrationDAO regDao;
	
	@Autowired
	private UserDAO userDao;

	@PostMapping(
			  value = "/regitratonFormSubmissionUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> regitratonFormSubmissionUser(@RequestBody Registration regObj) {
		try {
			SimpleEmailController emailobj= new SimpleEmailController();
			
			int result = regDao.registrationForm(regObj);
			System.out.println("result" + result);
			if (result == 1) {
				List<User> users = userDao.getAllUsers();
			
				int j=0;
				for(int i=0;i<users.size();i++)
				{
					if(users.get(i).getUserType()!=null)
					{
						if(users.get(i).getUserType().equals("Admin") || users.get(i).getUserType().equals("Banker"))
						{
				            j=j+1;
						}
					}
					
				}
				
				System.out.println("count"+j);
				String  [] to = new String [j];

				for(int i=0;i<users.size();i++)
				{
					if(users.get(i).getUserType()!=null)
					{
					if(users.get(i).getUserType().equals("Admin") || users.get(i).getUserType().equals("Banker"))
					{
					
						to[i]= users.get(i).getEmail();
						
					}
					}
				}
				
	
				 emailobj.sendFromGMail( to, "New Regitration details have been recieved", "Hi,\nNew Registration details has been recieved. Please find below details\n");
				return new ResponseEntity<>("Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("Error", HttpStatus.OK);
		}
	}
	
	
}
