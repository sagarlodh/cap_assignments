package io.org.bank;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBank {

	public static void main(String[] args) {
		
		AbstractApplicationContext fac =  new ClassPathXmlApplicationContext("spring.xml");
		fac.registerShutdownHook();
		
		/*
		 * getting the beans
		 */
		BankAccount bankaccount = (BankAccount)fac.getBean("bankAccount");
		BankAccountController bankControl = (BankAccountController)fac.getBean("bankAccountController");
		BankAccountServiceImpl bankService = (BankAccountServiceImpl)fac.getBean(BankAccountServiceImpl.class);
		BankAccountepositoryImpl bankRepo = (BankAccountepositoryImpl)fac.getBean(BankAccountepositoryImpl.class);
		
		bankaccount.toString();
		System.out.println("--------------------------------------------");
		System.out.println("OPERATIONS : ");
		System.out.println("[1] Deposit");
		System.out.println("[2] Withdraw");
		System.out.println("[3] Get Balance");
		System.out.println("[4] Fund Transfer");
		Scanner n = new Scanner(System.in);
		System.out.println("Enter your choice : ");
		int choice = n.nextInt();
		// ENTERING SWITCH CASE
		switch(choice) {
		case 1:
			System.out.println("Enter deposit amount : ");
			double depositAmount = n.nextDouble();
			bankControl.deposit(bankaccount.getAccountId(), depositAmount);
			break;
		case 2:
			double withdrawAmount = n.nextDouble();
			bankControl.withdraw(bankaccount.getAccountId(), withdrawAmount);
			break;
		case 3:
			bankControl.getBalance(bankaccount.getAccountId());
			break;
		case 4:
			// NOT YET IMPLEMENTED
			System.out.println("Enter Fund Transfer amount : ");
			double transferAmount = n.nextDouble();
			bankControl.fundTransfer(bankaccount.getAccountId(), choice, transferAmount);
			break;
		default:
			System.exit(0); 			/// WILL BE CHANGED LATER FOR RECURSION OF MENU
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
