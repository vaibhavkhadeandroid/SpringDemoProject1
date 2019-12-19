package com.example.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")

public class Demo11Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Demo11Application.class, args);
		System.out.print("jbjkdvkj");
	}
	
	
	
	@Bean
	public LocaleResolver getLocaleResolver() {
		
		SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		
		return sessionLocaleResolver;
	}

	
	@Bean 
	public ResourceBundleMessageSource bandlemessagesource() {
		ResourceBundleMessageSource resourceBundleMessageSource =new ResourceBundleMessageSource();
		
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
		
		
	}
}
