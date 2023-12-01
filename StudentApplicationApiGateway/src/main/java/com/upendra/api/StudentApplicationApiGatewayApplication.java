package com.upendra.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentApplicationApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplicationApiGatewayApplication.class, args);
	}

}
