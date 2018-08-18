/**
 * 
 */
package com.vector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BOLogin;
import com.vector.Beans.InicioSesionBean;


/**
 * @author Claudio
 *
 */
@RestController
public class InicioSesionController {
	
	
	
	@Autowired
	private BOLogin login;
	
	
	@RequestMapping(value = "/Sesion/listarusuarios", method = RequestMethod.POST)
	public ResponseEntity<List<InicioSesionBean>> consulta(){
		System.out.println("Ingresando a listar usuarios ");
		List<InicioSesionBean> usuarios = login.ListarUsuarios();
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<InicioSesionBean>>(usuarios, HttpStatus.OK);
		}
	}
	
	
	
	
	@RequestMapping(value = "/Sesion/insertarusuario", method = RequestMethod.POST)
	public ResponseEntity<InicioSesionBean> insertar(@RequestBody InicioSesionBean datos){
		InicioSesionBean resp = new InicioSesionBean();
		resp =(InicioSesionBean) login.CreateUser(datos);
		return new ResponseEntity<InicioSesionBean>(resp,HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/Sesion/verificarLogin", method = RequestMethod.POST)
	public ResponseEntity<String> verificarlogin(@RequestBody InicioSesionBean datos){
		String resp = login.VerificarUsuario(datos);
		System.out.println("Usuario "+datos.getUsuario()+" Contra "+datos.getContra());
		return new ResponseEntity<String>(resp,HttpStatus.OK);
	}

	
	@RequestMapping(value = "{proyecto}/{modulo}/{modulo.accion}", method = RequestMethod.POST)
	public ResponseEntity<List<InicioSesionBean>> consulta2(){
		System.out.println("Ingresando a listar usuarios ");
		List<InicioSesionBean> usuarios = login.ListarUsuarios();
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<InicioSesionBean>>(usuarios, HttpStatus.OK);
		}
	}
	
}
