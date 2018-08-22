package com.vector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

@RestController
public class DatosPersonalesController {
	@Autowired
	private BODatosPersonales bodatos;
	
	@RequestMapping("/SGRHWebService/DatosPersonales/listar")
	public ResponseEntity<List<DatosPersonalesBean>> Listar(){
		List<DatosPersonalesBean> resp = bodatos.Listar();
		if(resp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosPersonalesBean>>(resp, HttpStatus.OK);
		}
	}

}
