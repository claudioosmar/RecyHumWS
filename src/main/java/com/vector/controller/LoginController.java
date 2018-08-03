package com.vector.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import com.vector.model.DatosLogin;

import com.vector.service.LoginService;

@RestController
public class LoginController {
@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/listaruser", method = RequestMethod.POST)
	public ResponseEntity<List<DatosLogin>> consultaLogin() {
		List<DatosLogin> login = loginService.findAll();
		if (login.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<DatosLogin>>(login, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/insertaruser", method = RequestMethod.POST)
	public ResponseEntity<DatosLogin> insertar(@RequestBody DatosLogin body){
		loginService.save(body);
		return new ResponseEntity<DatosLogin>(HttpStatus.CREATED);
	}
	
	
@RequestMapping(value = "/actualizaruser", method= RequestMethod.POST)
public ResponseEntity<DatosLogin> actualizaruser(@RequestBody DatosLogin body){
 loginService.actualizar(body);
	return new ResponseEntity<DatosLogin>(HttpStatus.CREATED);
}


	@RequestMapping (value ="/borraruser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> borraruser(@PathVariable ("id") long id){
		Optional<DatosLogin>resultado= loginService.findByOne(id);
		DatosLogin datos = new DatosLogin();
		if(resultado.isPresent()) {
			datos = resultado.get();
		}if(datos == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			loginService.borrar(id);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping (value ="/buscaruserid/{id}", method = RequestMethod.POST)
	public ResponseEntity<DatosLogin> buscaruserid(@PathVariable ("id") long id){
		Optional<DatosLogin>resultado= loginService.findByOne(id);
		DatosLogin datos = new DatosLogin();
		if(resultado.isPresent()) {
			datos = resultado.get();
		}if(datos == null) {
			return new ResponseEntity<DatosLogin>(HttpStatus.NOT_FOUND);
		}
		else {
		}
		return new ResponseEntity<DatosLogin>(datos,HttpStatus.OK);
	}
	

	@RequestMapping (value ="/buscarusername/{nombre}", method = RequestMethod.POST)
	public ResponseEntity<DatosLogin> buscarusername(@PathVariable("nombre") String nombre){
		DatosLogin datos= loginService.findByName(nombre);
		if(datos == null) {
			return new ResponseEntity<DatosLogin>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<DatosLogin>(datos,new HttpHeaders(),HttpStatus.OK);	
		}
		
	}
}
