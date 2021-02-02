package io.org.javaBrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Property {

	public static void main(String[] args) {
		ApplicationContext fac = new ClassPathXmlApplicationContext("get.xml");
		
		DbConfig d = (DbConfig)fac.getBean("DbConfig");
		
		// getting id as bean
		System.out.println(d.getId());
		System.out.println("-----------------------------------");
		
		// OUT the information
		d.information();

	}

}
