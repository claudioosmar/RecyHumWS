package com.vector.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages= {"com.vector"})
public class WebServiceMainController{
		
	public static void main(String[] args) {
		SpringApplication.run(WebServiceMainController.class, args);
	}
}
