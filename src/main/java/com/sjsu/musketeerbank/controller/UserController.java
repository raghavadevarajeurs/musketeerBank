package com.sjsu.musketeerbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sjsu.musketeerbank.dao.UserDAO;
import com.sjsu.musketeerbank.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;

	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		try {

			List<User> users = userDao.getAllUsers();

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@GetMapping("/getAllCustomerNames")
	public ResponseEntity<List> getAllCustomerNames() {
		try {

			List users = userDao.getAllCustomerNames();

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@PostMapping(
			  value = "/createUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createUser(@RequestBody User userObj) {
		try {
			System.out.println("Creating user" + userObj.getUserName());
			
			int result = userDao.createUser(userObj);
			System.out.println("result" + result);
			if (result == 1) {
				return new ResponseEntity<>("Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.OK);
		}
	}

	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@PostMapping(
			  value = "/checkUserExists", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> checkUserExists(@RequestBody User userObj) {
		try {

			User user = userDao.checkUserExists(userObj);
			
			//List<User> users = userDao.getAllUsers();

			if (user==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@PostMapping(
			  value = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> loginUser(@RequestBody User userObj) {
		try {

			User user = userDao.loginUser(userObj);
			
			if (user==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
