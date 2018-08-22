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

import com.vector.BO.BODatosLogin;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.MsgBean;


/**
 * @author Claudio
 *
 */

@RestController
@RequestMapping("/SGRHWebService/{modulo.uno}")
public class DatosInicioSesionController {
	
	
	
	@Autowired
	private BODatosLogin login;
	

	@RequestMapping(path = "/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosInicioSesionBean datos){
		System.out.print("Se creo un usuario");
		return new ResponseEntity<MsgBean>(login.CreateUser(datos),HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(path = "/Verificar", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> verificarlogin(@RequestBody DatosInicioSesionBean datos){
		MsgBean respuesta = new MsgBean();
		if(datos.getUsuario().isEmpty()&&datos.getContraseña().isEmpty()) {
			respuesta.setMsjAccion("falta usuario y/o contraseña");
		}else {
		respuesta.setMsjAccion(login.VerificarUsuario(datos));
		System.out.println("Usuario "+datos.getUsuario()+" Contra "+datos.getContraseña());
	}
		return new ResponseEntity<MsgBean>(respuesta,HttpStatus.OK);
		
	}

	
	@RequestMapping(path = "/Listar", method = RequestMethod.POST)
	public ResponseEntity<List<DatosInicioSesionBean>> consulta(){
		System.out.println("Ingresando a listar usuarios ");
		List<DatosInicioSesionBean> usuarios = login.ListarUsuarios();
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosInicioSesionBean>>(usuarios, HttpStatus.OK);
		}
	}
	
}
