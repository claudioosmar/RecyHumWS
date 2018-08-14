package com.vector.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.vector"})
public class WebServiceMainController{
		
	public static void main(String[] args) {
		SpringApplication.run(WebServiceMainController.class, args);
	}
}
