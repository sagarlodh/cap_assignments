package io.org.javaBrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.beans.factory.xml.XmlBeanFactory;

public class DrawingApp {
	public static void main(String[] args) {
		
		AbstractApplicationContext fac = new ClassPathXmlApplicationContext("spring.xml");
		fac.registerShutdownHook();
		Triangle triangle = (Triangle)fac.getBean("triangle");
		int e = triangle.draw(2);
		System.out.println("-----------------------------------");
		System.out.println("The result from Triangle Bean : "+e);
		System.out.println("-----------------------------------");
		}
}
