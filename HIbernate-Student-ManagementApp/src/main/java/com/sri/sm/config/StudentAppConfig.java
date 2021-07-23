package com.sri.sm.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sri.sm.helper.StudentHelper;



@EnableWebMvc
@Configuration()
@ComponentScan(basePackages = "com.sri.sm")
@PropertySource(value = {"classpath:dbconnection.properties","classpath:email.properties"})
public class StudentAppConfig implements WebMvcConfigurer{

	Logger logger = Logger.getLogger(StudentAppConfig.class.getName());
	
	@Autowired
	Environment environment;
	
	@Autowired
	StudentHelper studentHelper;
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/views/*").addResourceLocations(
	 * "classpath:/views/"); }
	 */
	
	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource reloadableResourceBundleMessageSource = new ResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasename("customValidator");
		return reloadableResourceBundleMessageSource;
	}
	/*
	@Bean
	JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		return jdbcTemplate;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		//driverManagerDataSource.setDriverClassName("${jdbc.driverClassName}");
		driverManagerDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		//driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl(environment.getProperty("jdbc.url"));
		//driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername(environment.getProperty("jdbc.username"));
		//driverManagerDataSource.setUsername("sri");
		driverManagerDataSource.setPassword(environment.getProperty("jdbc.password"));
		//driverManagerDataSource.setPassword("sri");
		
		return driverManagerDataSource;
		
	}
	*/
	@Bean
	public JavaMailSender getJavaMailSender() {
		logger.info("->>JavaMailSender Bean Creation");
		
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost(environment.getProperty("mail.smtp.host"));
		javaMailSenderImpl.setUsername(environment.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(environment.getProperty("mail.password"));
		javaMailSenderImpl.setPort(studentHelper.getIntProperties("mail.smtp.port"));
		javaMailSenderImpl.setJavaMailProperties(studentHelper.getMailProperties());
		
		return javaMailSenderImpl;
		
	}
	
	
	
	
	
}


