package io.org.listProg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class QuestionTest {

	@Test
	void test() {
		// initializing
		ApplicationContext fac = new ClassPathXmlApplicationContext("answers.xml");
		
		// getting the information from the bean
		Question q = (Question)fac.getBean("questions");
		
		// checking whether 'question' is contained or not
		assertEquals(true,fac.containsBean("questions"),"this should be true..");
	}

}
