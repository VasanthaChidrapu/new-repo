package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = "com.example.demo.Repository,com.example.demo.Repository2,com.example.demo.service2,com.example.demo.controller2")
//@EntityScan(basePackages = "com.example.demo.entity")
//@EnableJpaRepositories(basePackages = "com.example.demo.service2,com.example.demo.Repository2")
public class Client2Application {
	
	
@Value("${customer.service.url}")
private String customerServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(Client2Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	public WebClient webClient () {
		WebClient webClient =WebClient.builder()
				.baseUrl("http://client1").build();
		
		return webClient;
	}
}