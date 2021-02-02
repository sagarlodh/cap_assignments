package io.org.bank;

import org.springframework.stereotype.Component;

@Component
public interface BankAccountRepository {
	
	public double getBalance(long accountId);
	public double updateBalance(long accountId, double newBalance);
}
