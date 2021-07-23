package com.sri.sm.helper;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:dbconnection.properties","classpath:email.properties"})
public class StudentHelper {
	
	Logger logger = Logger.getLogger(StudentHelper.class.getName());
	@Autowired
	Environment environment;
	public Integer getIntProperties(String key) {
		
		logger.info("value:"+environment.getProperty(key));
		return Integer.parseInt(environment.getProperty(key));
	}
	
	
	public Properties getMailProperties(){
		
		Properties javaMailProperties  = new Properties();
		javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.socketFactory.port", "465");
		javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		return javaMailProperties;
	}

}
