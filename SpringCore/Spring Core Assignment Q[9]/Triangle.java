package io.org.javaBrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements InitializingBean, DisposableBean {
	
	public int draw(int r) {
	return r*2;
	}
	
	/**
	 * here showing lifecycle from BEAN initializations
	 * to destroying of it through [InitializingBean, DisposableBean]
	 * and customer [init, dest] methods
	 */
	
	public void init() {
		System.out.println("**************************************************");
		System.out.println("Initialized the Triangle Bean1 using [INIT] method");	
	}
	
	
	public void dest() {
		System.out.println("**************************************************");
		System.out.println("Destroyed the Triangle Bean2 using [DESTROY] method");	
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("here we can have just initialized the Triangle Bean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("here we can have just destroyed the Triangle Bean");
		
	}
	
	
}
