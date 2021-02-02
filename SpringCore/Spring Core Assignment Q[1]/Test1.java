package io.org.javaBrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext fac = new ClassPathXmlApplicationContext("springforOne.xml");
		
		Customer customer = (Customer)fac.getBean("info");
		System.out.println(customer.toString());

	}

}
