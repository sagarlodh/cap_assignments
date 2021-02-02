package io.org.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TestBankTest {

	@Test
	void test() {
		// initializing
		AbstractApplicationContext fac =  new ClassPathXmlApplicationContext("spring.xml");
		
		// getting the information from the bean
		BankAccount b = (BankAccount)fac.getBean("bankAccount");
		
		// checking whether 'bankAccount' is contained or not
		assertEquals(true,fac.containsBean("bankAccount"),"this should be true..");
	}

}
