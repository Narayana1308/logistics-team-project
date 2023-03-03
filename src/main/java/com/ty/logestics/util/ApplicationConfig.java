package com.ty.logestics.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableSwagger2
public class ApplicationConfig {
	
	
	public Docket getDocket() {
		Contact contact=new Contact("ty", "www.ty.com", "ty@123gmail.com");
		
		List<VendorExtension> extensions=new  ArrayList<>();
		
		ApiInfo info=new ApiInfo("logistics app", "logistics v1.0", "version 1.0", "www.ty.com", contact, "ty123Yantra","www.tyyantra123.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty.logestics")).build().apiInfo(info).useDefaultResponseMessages(false);
	}
	
	

}
