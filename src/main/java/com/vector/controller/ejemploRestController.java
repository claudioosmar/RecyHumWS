package com.vector.controller;

/**
 * @author Claudio
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.model.User;
import com.vector.repository.UserRepository;

@RestController
public class ejemploRestController {
	@Autowired
	private UserRepository userRep;
	private int cont=1;
	
	@RequestMapping(value = "/listarusuarios", method = RequestMethod.POST)
	public ResponseEntity<List<User>> consulta(){
		System.out.println("Ingresando a listar usuarios "+cont++);
		List<User> usuarios = userRep.findAll();
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<User>>(usuarios, HttpStatus.OK);
		}
	}
	
	
	
	
	@RequestMapping(value = "/insertarusuario", method = RequestMethod.POST)
	public ResponseEntity<User> insertar(@RequestBody User body){
		User resp = new User();
		resp =userRep.create(body);
		return new ResponseEntity<User>(resp,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/verificaruser", method = RequestMethod.POST)
	public ResponseEntity<String> verificarlogin(@RequestBody User in){
		String resp = userRep.verificarusuario(in);
		return new ResponseEntity<String>(resp,HttpStatus.OK);
	}
}
