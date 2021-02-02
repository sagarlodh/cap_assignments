package io.org.javaBrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.annotation.*;
import javax.annotation.*;

public class Triangle{
	
	public int draw(int r) {
	return r*2;
	}
	
	public void init() {
		System.out.println("**************************************************");
		System.out.println("Initialized the Triangle Bean1 using [INIT] method");	
	}
	
	
	public void dest() {
		System.out.println("**************************************************");
		System.out.println("Destroyed the Triangle Bean2 using [DESTROY] method");	
	}

	@PostConstruct
	public void initTriangle() {
		System.out.println("here we can have just initialized the Triangle Bean");	
	}
	
	@PreDestroy
	public void destTriangle() {
		System.out.println("here we can have just initialized the Triangle Bean");	
	}
	
}
