/**
 * 
 */
package com.vector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.LoginBO;
import com.vector.Beans.BeanInicioSesion;


/**
 * @author Claudio
 *
 */
@RestController
public class InicioSesionController {
	@Autowired
	private LoginBO<BeanInicioSesion> login;
	
	
	@RequestMapping(value = "/listarusuarios", method = RequestMethod.POST)
	public ResponseEntity<List<BeanInicioSesion>> consulta(){
		System.out.println("Ingresando a listar usuarios ");
		List<BeanInicioSesion> usuarios = login.ListarUsuarios();
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<BeanInicioSesion>>(usuarios, HttpStatus.OK);
		}
	}
	
	
	
	
	@RequestMapping(value = "/insertarusuario", method = RequestMethod.POST)
	public ResponseEntity<BeanInicioSesion> insertar(@RequestBody BeanInicioSesion datos){
		BeanInicioSesion resp = new BeanInicioSesion();
		resp =(BeanInicioSesion) login.CreateUser(datos);
		return new ResponseEntity<BeanInicioSesion>(resp,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/verificaruser", method = RequestMethod.POST)
	public ResponseEntity<String> verificarlogin(@RequestBody BeanInicioSesion datos){
		String resp = login.VerificarUsuario(datos);
		return new ResponseEntity<String>(resp,HttpStatus.OK);
	}

}
