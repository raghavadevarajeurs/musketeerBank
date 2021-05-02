package com.sjsu.musketeerbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sjsu.musketeerbank.dao.AccountDAO;
import com.sjsu.musketeerbank.dao.UserDAO;
import com.sjsu.musketeerbank.model.Account;
import com.sjsu.musketeerbank.model.User;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDAO acctDao;
	

	@Autowired
	private UserDAO userDao;
	
	
	@GetMapping("/getAccountDetails")
	public ResponseEntity<List<User>> getAccountDetails(@RequestBody Account acctObj) {
		try {

			//List<User> users = acctDao.getAccountDetails();
			List<User> users=null;

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(
			  value = "/createAccount", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createAccount(@RequestBody User userObj) {
		try {
			
			System.out.println("Creating Account" + userObj.getUserName());
			SimpleEmailController emailobj= new SimpleEmailController();
			User user = userDao.checkUserExists(userObj);

			if (user.getUserId()==null) { // If User does not exist -- Create a User (Users Table), and Create Account (account) -- Notify email with the UserName and password
				System.out.println("Here");
				int result = userDao.createUser(userObj);
				System.out.println("result" + result);
				if (result == 1) {
				 user = userDao.checkUserExists(userObj); // fetch user id
				 System.out.println("user" + user.getUserId());
				 int accresult = acctDao.createAccountNew(userObj,user.getUserId());
					System.out.println("accresult" + accresult);
					
					String accntid=acctDao.getaccountID(user.getUserId());
					int accntnumber=61162545+Integer.parseInt(accntid);
					int upfateacc=acctDao.updateAccountNew(accntid, accntnumber);
					if(upfateacc==1)
					{
					String[] to = { userObj.getEmail() }; 
					emailobj.sendFromGMail( to, "Welcome to TPM Bank", "Hello "+user.getFirstName()+" "+user.getLastName()+",/nYour account has been created in TPM Bank.\n Please find below account details\nAccount Number:"+accntnumber+"\nRegards,\n TPM Team");
					}
				} else { 
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			else // If User exists -- Create an Account -- Notify the user
			{
				
				int accresult = acctDao.createAccountNew(userObj,user.getUserId());
				System.out.println("accresult else" + user.getUserId());
				String accntid=acctDao.getaccountID(user.getUserId());
				int accntnumber=61162545+Integer.parseInt(accntid);
				int updateacc=acctDao.updateAccountNew(accntid, accntnumber);
				if(updateacc==1)
				{
				String[] to = { user.getEmail() }; 
				emailobj.sendFromGMail( to, "Welcome to TPM Bank", "Hello "+user.getFirstName()+" "+user.getLastName()+",\nYour account has been created in TPM Bank.\n Please find below account details\nAccount Number:"+accntnumber+"\nRegards,\n TPM Team");
				}
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.OK);
		}
	}

}
