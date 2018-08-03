package com.vector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ejemploController {

	@ResponseBody
	@RequestMapping("/holaMundo")
	public String myFunction() {
		return "Hola Mundo";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
