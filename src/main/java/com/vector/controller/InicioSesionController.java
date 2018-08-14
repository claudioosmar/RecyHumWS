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
import com.vector.Beans.InicioSesionBean;


/**
 * @author Claudio
 *
 */
@RestController
public class InicioSesionController {
	@Autowired
	private LoginBO login;
	
	
	@RequestMapping(value = "/listarusuarios", method = RequestMethod.POST)
	public ResponseEntity<List<InicioSesionBean>> consulta(){
		System.out.println("Ingresando a listar usuarios ");
		List<InicioSesionBean> usuarios = login.ListarUsuarios();
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<InicioSesionBean>>(usuarios, HttpStatus.OK);
		}
	}
	
	
	
	
	@RequestMapping(value = "/insertarusuario", method = RequestMethod.POST)
	public ResponseEntity<InicioSesionBean> insertar(@RequestBody InicioSesionBean datos){
		InicioSesionBean resp = new InicioSesionBean();
		resp =(InicioSesionBean) login.CreateUser(datos);
		return new ResponseEntity<InicioSesionBean>(resp,HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/verificaruser", method = RequestMethod.POST)
	public ResponseEntity<String> verificarlogin(@RequestBody InicioSesionBean datos){
		String resp = login.VerificarUsuario(datos);
		System.out.println("Usuario "+datos.getUsuario()+" Contra "+datos.getContra());
		return new ResponseEntity<String>(resp,HttpStatus.OK);
	}

}
