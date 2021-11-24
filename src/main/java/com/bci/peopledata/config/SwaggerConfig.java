package com.bci.peopledata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docApi() {
	
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bci.peopledata.rest"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());

	}
	
	private ApiInfo getApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Documentación Evaluación: JAVA")
				.version("1.0")
				.description("Swagger. Documentación Evaluación: JAVA")
				.contact(new Contact("Gabriel Romero", "https://gromero.tech", "ing.gabriel.romero@gmail.com"))
				.license("Apache Livense Version 2.0")
				.build();
				
	}
	

}
