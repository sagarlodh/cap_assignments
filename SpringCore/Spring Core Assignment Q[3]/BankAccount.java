package io.org.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccount {
	private long accountId;
	private String accountHolderName;
	private String  accountType;
	private double accountBalance;
	
	// GETTERs N SETTERs
	//
	// we can also use '@Bean' with methods, and result will be the same
	// as without it but context will not be configured earlier than calling
	public long getAccountId() {
		return accountId;}
	public void setAccountId(long accountId) {
		this.accountId = accountId;}
	public String getAccountHolderName() {
		return accountHolderName;}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;}
	public String getAccountType() {
		return accountType;}
	public void setAccountType(String accountType) {
		this.accountType = accountType;}
	public double getAccountBalance() {
		return accountBalance;}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;}
	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ",\n accountHolderName=" + accountHolderName + ",\n accountType="
				+ accountType + ",\n accountBalance=" + accountBalance + "]";
	}
}
