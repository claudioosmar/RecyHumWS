package com.vector.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: WebServiceMainController.java
 *   Descripción:  controlador main
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@SpringBootApplication(scanBasePackages= {"com.vector"})
@PropertySource("classpath:web.properties")
public class WebServiceMainController{
		
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebServiceMainController.class, args);
	}
}
