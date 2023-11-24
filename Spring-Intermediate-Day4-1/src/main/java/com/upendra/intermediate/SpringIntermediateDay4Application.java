package com.upendra.intermediate;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info = @Info(title = "User"))
@SpringBootApplication
public class SpringIntermediateDay4Application {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntermediateDay4Application.class, args);
	}

}
