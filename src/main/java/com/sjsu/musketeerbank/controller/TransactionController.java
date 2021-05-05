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
import org.springframework.web.bind.annotation.RequestParam;

import com.sjsu.musketeerbank.dao.AccountDAO;
import com.sjsu.musketeerbank.dao.TransactionDAO;
import com.sjsu.musketeerbank.dao.UserDAO;
import com.sjsu.musketeerbank.model.Account;
import com.sjsu.musketeerbank.model.Transaction;
import com.sjsu.musketeerbank.model.User;
import com.sjsu.musketeerbank.model.UserAccount;

@Controller
public class TransactionController {
	
	@Autowired
	private AccountDAO acctDao;
	

	@Autowired
	private TransactionDAO transDao;
	
	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@GetMapping("/getTransactions")
	public ResponseEntity<List<Account>> getTransactions(@RequestParam String userName) {
		try {

			List<Account> accounts = acctDao.getUserAccountDetails(userName);

			if (accounts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
	@PostMapping(
			  value = "/createTransaction", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createTransaction(@RequestBody Transaction transObj) {
		try {
			System.out.println("Account Number"+transObj.getAccountNumber());
			double accbalance=acctDao.getUserAccountBalanceByAccno(transObj.getAccountNumber());
	
			if(accbalance==-9999)
			{
				return new ResponseEntity<>("Not a valid Account", HttpStatus.OK);
			}
			System.out.println("accbalance "+accbalance);
		
			double amountTemp=transObj.getAmount();
			double newBalance;
			if(transObj.getTransactionType().equalsIgnoreCase("Withdrawal"))
			{
				if((accbalance-amountTemp)>=0)
				{
					newBalance=accbalance-amountTemp;
				}
				else
				{
					return new ResponseEntity<>("No Balance", HttpStatus.PARTIAL_CONTENT);
				}
			}
			else if(transObj.getTransactionType().equalsIgnoreCase("Deposit"))
			{
				newBalance=accbalance+amountTemp;
			}
			else
			{
				return new ResponseEntity<>("Invalid Transcation Type", HttpStatus.PARTIAL_CONTENT);
			}
			transObj.setBalance(newBalance);
			int result = transDao.createTransaction(transObj);
			if(result==1)
			{
				int updateaccbal=acctDao.updateAccountBalance(newBalance,Integer.parseInt(transObj.getAccountNumber()));
			}
			else
			{
				return new ResponseEntity<>("Error", HttpStatus.OK);
			}
			
			return new ResponseEntity<>("Success",HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception"+e);
			return new ResponseEntity<>("Error", HttpStatus.OK);
		}
	}

}
