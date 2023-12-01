package com.upendra.mentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MentorApplication {

	@Bean
	public WebClient webClient()
	{
		return WebClient.builder().build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MentorApplication.class, args);
	}

}
