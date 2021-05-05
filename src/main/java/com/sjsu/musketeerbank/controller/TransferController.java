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
import com.sjsu.musketeerbank.dao.TransferDAO;
import com.sjsu.musketeerbank.model.Transfer;


@Controller
public class TransferController {
	
	
@Autowired
private AccountDAO acctDao;	

@Autowired
private TransferDAO transferDao;

@CrossOrigin(origins = {"http://localhost:4200","https://localhost:4200"})
@PostMapping(
		  value = "/createTransferAmount", consumes = "application/json", produces = "application/json")
public ResponseEntity<String> createTransaction(@RequestBody Transfer transObj) {
	try {
		   double amountTemp=transObj.getAmount();
		   double newfromAccBalance;
		   String fromaccno=transObj.getFromAccountNumber();
			double fromaccbalance=acctDao.getUserAccountBalanceByAccno(fromaccno);
			
			if(fromaccbalance==-9999)
			{
				return new ResponseEntity<>("Not a valid Account", HttpStatus.OK);
			}
			
			if((fromaccbalance-amountTemp)>=0)
			{
				newfromAccBalance=fromaccbalance-amountTemp;
			}
			else
			{
				return new ResponseEntity<>("No Balance", HttpStatus.OK);
			}
			
		
		if(transObj.getTransfertype().equalsIgnoreCase("Between the accounts"))
		{
			    String toaccno=transObj.getToAccountNumber();
				double toaccbalance=acctDao.getUserAccountBalanceByAccno(toaccno);
				double newtoaccbalance;
				if(toaccbalance==-9999)
				{
					return new ResponseEntity<>("Not a valid Account", HttpStatus.OK);
				}
				
				newtoaccbalance=toaccbalance+amountTemp;
				int result = transferDao.createTransfer(transObj);
				if(result==1)
				{
					int updateaccbal=acctDao.updateAccountBalance(newfromAccBalance,Integer.parseInt(fromaccno));
					int updateaccbal_1=acctDao.updateAccountBalance(newtoaccbalance,Integer.parseInt(toaccno));
					if(updateaccbal==1 && updateaccbal_1==1)
					{
						return new ResponseEntity<>("Success",HttpStatus.OK);
					}
					else
					{
						return new ResponseEntity<>("Error", HttpStatus.OK);
					}
				}
				else
				{
					return new ResponseEntity<>("Error", HttpStatus.OK);
				}
		}
		else if(transObj.getTransfertype().equalsIgnoreCase("Bill Payments"))
		{
			int result = transferDao.createTransfer(transObj);
			if(result==1)
			{
				int updateaccbal=acctDao.updateAccountBalance(newfromAccBalance,Integer.parseInt(fromaccno));
				if(updateaccbal==1)
				{
					return new ResponseEntity<>("Success",HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<>("Error", HttpStatus.OK);
				}
			}
			else
			{
				return new ResponseEntity<>("Error", HttpStatus.OK);
			}
		}
		else
		{
			return new ResponseEntity<>("Invalid Transfer Type",HttpStatus.OK);
		}
				
	
	} catch (Exception e) {
		System.out.println("Exception"+e);
		return new ResponseEntity<>("Error:"+e, HttpStatus.OK);
	}
}

}
