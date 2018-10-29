/**
 * 
 */
package com.vector.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosLogin;
import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosInicioSesionController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosInicioSesionController extends Log{
	
	
	
	/** The login. */
	@Autowired
	private BODatosLogin login;

	

	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosInicioSesionBean datos){
		info("Se creo un usuario"+datos.getIdtipocorreo()+datos.getNombre()+"\n");
		MsgBean respuesta =login.CreateUser(datos);
		
		return new ResponseEntity<MsgBean>(respuesta,HttpStatus.OK);
	}
	
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosInicioSesionBean>buscar(@RequestBody DatosInicioSesionBean datos){
		info("Se busco los datos del usuario"+datos.getiduser()+"\n");
		return new ResponseEntity<DatosInicioSesionBean>(login.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: verificarlogin 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Verificar", method = RequestMethod.POST)
	public ResponseEntity<List<DatosFormularioBean>> verificarlogin(@RequestBody @Valid DatosInicioSesionBean datos){
		info("se verifica el usuario"+"\n");/*letreros*/
		info("Datos de sesion "+datos.toString());
		datos.setAccion("Inteto de logueo Usuario "+datos.getUsuario());
		List<DatosFormularioBean> respuestaLogin =login.VerificarUsuario(datos);
		if (respuestaLogin.size()==1) {
			return new ResponseEntity<List<DatosFormularioBean>>(respuestaLogin,HttpStatus.OK);	
		}else {
			
			return new ResponseEntity<List<DatosFormularioBean>>(respuestaLogin,HttpStatus.BAD_REQUEST);
		}
			
	}

	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Listar", method = RequestMethod.POST)
	public ResponseEntity<List<DatosInicioSesionBean>> consulta(@RequestBody @Valid DatosPistaAuditoraBean audit){
		info("Se ingreso a listar Usuarios"+"\n");
		List<DatosInicioSesionBean> usuarios = login.ListarUsuarios(audit);
		if(usuarios.isEmpty()) {
			info("no se encontro datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los usuarios");
			return new ResponseEntity<List<DatosInicioSesionBean>>(usuarios, HttpStatus.OK);
		}
	}
	
	/**
	 * Clase: consultaprueba 
	 * Descripcion:.
	 *
	 * @return Retorna response entity}
	 * @deprecated
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/VerificarPrueba", method = RequestMethod.POST)
	public ResponseEntity<List<DatosFormularioBean>> consultaprueba(){
		info("Ingresando a listar formularios ");
		List<DatosFormularioBean> retorno = new ArrayList<DatosFormularioBean>();
		DatosFormularioBean form= new DatosFormularioBean();
		form.setNomformulario("DatosPersonales");
		form.setStatus(true);
		retorno.add(form);
		form = new DatosFormularioBean();
		form.setNomformulario("Idiomas");
		form.setStatus(false);
		retorno.add(form);
		return new ResponseEntity<List<DatosFormularioBean>>(retorno, HttpStatus.OK);
		
		}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosInicioSesionBean datos){
		info("Se modifico el usuario con id de persona: "+datos.getiduser());
		return new ResponseEntity<MsgBean>(login.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosSesion/EliminarUser",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>eliminar(@RequestBody DatosInicioSesionBean datos){
		info("Se elimino usuario: "+datos.getiduser());
		return new ResponseEntity<MsgBean>(login.Eliminar(datos),HttpStatus.OK);
	}
	
}
