package com.dishan.myrestapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



//this class is the only thing which is responsible for SWAGGER DOCUMENATATION
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	public   Contact DEFAULT_CONTACT = new Contact("Dishan Verma", "ksdfnsdlf", "vermadishan@gmail.com");
	  public  ApiInfo DEFAULT_APP_INFO = new ApiInfo("Api Documentation hai ye mera ", "Api Documentation", "91.0", "urn:tos",
	          DEFAULT_CONTACT, "Dishan Verma", "http://www.verma_ji.com");

	  @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_APP_INFO)
				//.produces(null)
				//.consumes(null)
				;
	}
}
