package io.org.listProg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class answerTest {

	public static void main(String[] args) {
		// initializing
		ApplicationContext fac = new ClassPathXmlApplicationContext("answers.xml");
		Question q = (Question)fac.getBean("questions");
		
		// printing out from toString() :
			//[a] list answers
			//[b] set answers
			//[c] map answers
		System.out.println(q.toString());
	}

}
