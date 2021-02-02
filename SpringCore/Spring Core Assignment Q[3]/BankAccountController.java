package io.org.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankAccountController {
	
	// FOR WORKING IN SERVICE LAYER
	@Autowired
	private BankAccountServiceImpl bankAccountServiceImpl;
	
	
	BankAccount b1 = new BankAccount();
	
	@ResponseBody
	public double withdraw(long accountId, double balance) {
		
		// WITHDRAW from service layer
		bankAccountServiceImpl.withdraw(accountId, balance);
		return accountId;
	}
	@ResponseBody
	public double deposit(long accountId, double balance) {
		
		// DEPOSIT from service layer
		bankAccountServiceImpl.deposit(accountId, balance);
		return accountId;
	}
	@ResponseBody
	public double getBalance(long accountId) {
		
		// GET BALANCE from service layer
		bankAccountServiceImpl.getBalance(accountId);
		return accountId;
	}
	@ResponseBody
	public boolean fundTransfer(long fromAccount, long toAccount, double amont) {
		
		// FUND TRANSFER from service layer
		// NOT IMPLEMENTED YET
		bankAccountServiceImpl.fundTransfer(fromAccount, toAccount, amont);
		return false;
	}

}
