package com.au;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AcharyaUniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcharyaUniversityApplication.class, args);
	}
	
	@Bean
	public Docket swaggerconfiguration()
	{
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.paths(PathSelectors.ant("/api/**"))
	.apis(RequestHandlerSelectors.basePackage("com.au.controller"))
	.build();
}
	
	
	@Bean 
	public WebMvcConfigurer corsConfigurer() 
	{ 
		return new WebMvcConfigurer() 
		{ 
			@Override 
			public void addCorsMappings(CorsRegistry registry) 
			{ 
				registry.addMapping("/api/**").allowedOrigins("http://localhost:8080"); 
				} 
			};
			}
	
}
