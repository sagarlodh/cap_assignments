package io.org.javaBrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// using property source
@PropertySource("classpath:dbConfig.properties")
// using component
@Component
public class DbConfig {
	
	private String driver_class_name;
	private String dburl;
	private int id;
	
	@Autowired
	private MessageSource messageSource;
	
	// using value from properties file
	@Value("${password}")
	private int password;
	
	//getting the message source
	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	// setting the message source
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	// OUT the info - 2 from file / 1 by value
	public void information()
	{
		System.out.println("Driver class name : "+this.messageSource.getMessage("driver_class_name",null,"this is default driver class",null));
		System.out.println("DB URL : "+this.messageSource.getMessage("dburl",null,"this is default this is dbUrl",null));
		System.out.println("Pass : "+password);
	}
	
	//constructor
	public DbConfig(String driver_class_name, String dburl, int password, int id) {
		super();
		this.driver_class_name = driver_class_name;
		this.dburl = dburl;
		this.password = password;
		this.id = id;
	}
	
	//getters n seters
	public String getDriver_class_name() {
		return driver_class_name;
	}
	public void setDriver_class_name(String driver_class_name) {
		this.driver_class_name = driver_class_name;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "DbConfig [driver_class_name=" + driver_class_name + ", dburl=" + dburl + ", password=" + password + ", id=" + id +"]";
	}
	
	

}
