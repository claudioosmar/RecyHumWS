package com.vector.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication(scanBasePackages= {"com.vector"})
@PropertySource("classpath:web.properties")
public class WebServiceMainController{
		
	public static void main(String[] args) {
		SpringApplication.run(WebServiceMainController.class, args);
	}
}
