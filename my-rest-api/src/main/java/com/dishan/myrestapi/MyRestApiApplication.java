package com.dishan.myrestapi;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@ComponentScan("com.dishan.myrestapi")
//@EnableZuulProxy
//the below thing is used by the filter
@ServletComponentScan("com.dishan")
public class MyRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestApiApplication.class, args);
	}
	
	//this bean is used for internationalization,,,,,,i.e setting up for different languages
	//this basically tells your local country
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
		
	}
	//to resolve messages for different locale -internationalization
	//Spring's application context is able to resolve text messages for a target locale by their keys. ... ResourceBundleMessageSource is the most common MessageSource implementation that resolves messages from resource bundles for different locales.
	@Bean(name="messageSource")
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
}
