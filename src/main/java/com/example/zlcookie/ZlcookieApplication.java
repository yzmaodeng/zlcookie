package com.example.zlcookie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
//https://blog.csdn.net/zcl_love_wx/article/details/51992999  这个文章讲的很清楚
@SpringBootApplication
public class ZlcookieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZlcookieApplication.class, args);
	}
	
	
	 @Bean  
	    public ServletRegistrationBean testServletRegistration() {  
	        ServletRegistrationBean registration = new ServletRegistrationBean(new TestServlet());  
	        registration.addUrlMappings("/hello");  
	        return registration;  
	    }  
	  
	    @Bean  
	    public FilterRegistrationBean testFilterRegistration() {  
	        FilterRegistrationBean registration = new FilterRegistrationBean(new TestFilter());  
	        registration.addUrlPatterns("/");  
	        return registration;  
	    }  
	      
	    @Bean  
	    public ServletListenerRegistrationBean<TestListener> testListenerRegistration(){  
	        ServletListenerRegistrationBean<TestListener> registration = new ServletListenerRegistrationBean<TestListener>(new TestListener());  
	        return registration;  
	    }  
	    
	    
		 @Bean  
		    public ServletRegistrationBean cookieDemoServlet() {  
		        ServletRegistrationBean registration = new ServletRegistrationBean(new CookieDemoServlet());  
		        registration.addUrlMappings("/cookie");  
		        return registration;  
		    }  
	    
	    
	    
}
