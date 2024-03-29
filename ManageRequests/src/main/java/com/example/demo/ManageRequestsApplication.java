package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManageRequestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageRequestsApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
