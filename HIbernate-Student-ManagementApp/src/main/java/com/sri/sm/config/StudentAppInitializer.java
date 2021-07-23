package com.sri.sm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class cls[] = {StudentAppConfig.class};
		return cls;
	}

	@Override
	protected String[] getServletMappings() {
		
		String[] mappings = {"/"};
		
		return mappings;
	}

}
