package io.org.javaBrains;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Test_JunitTest {

	@Test
	void test() {
		//Customer c = new Customer();
		ApplicationContext fac = new ClassPathXmlApplicationContext("springforOne.xml");
		
		Customer customer = (Customer)fac.getBean("info");
		assertEquals(true,fac.containsBean("address"),"this should be true..");
		assertEquals(true,fac.containsBean("info"),"this should also be true..");
		
	}

}
