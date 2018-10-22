/**
 * 
 */
package com.vector.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosCorreoAlt;
import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosCorreoAltController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosCorreoAltController extends Log {
	
	/** The correo. */
	@Autowired
	private BODatosCorreoAlt correo;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosCorreoAltBean>
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion crear correoalt
	@RequestMapping(path = "/SGRHWebService/DatosCorreo/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody @Valid List<DatosCorreoAltBean> datos){
		//Linea de impresion en consola que muestra datos del correoalt al ser creados
		info("Se creo un correo: "+datos.toString());
		return new ResponseEntity<MsgBean>(correo.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion Modificar correoalt
	@RequestMapping(path = "/SGRHWebService/DatosCorreo/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody @Valid DatosCorreoAltBean datos){
		//Linea de impresion en consola que muestra datos del correoalt al ser modificados
		info("Se modifico el correo: "+datos.toString());
		return new ResponseEntity<MsgBean>(correo.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion eliminar correoalt
	@RequestMapping(path = "/SGRHWebService/DatosCorreo/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody @Valid DatosCorreoAltBean datos){
		//Linea de impresion en consola que muestra datos del correoalt al ser eliminados
		info("se elimino el correo: "+datos.getCorreoNw());
		return new ResponseEntity<MsgBean>(correo.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion buscar correoalt
	@RequestMapping(path = "/SGRHWebService/DatosCorreo/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosCorreoAltBean> buscar(@RequestBody @Valid DatosCorreoAltBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		info("se busco el correo de la persona: "+datos.getIdpersona());
		return new ResponseEntity<DatosCorreoAltBean>(correo.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion listar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCorreo/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCorreoAltBean>> consulta(@RequestBody @Valid DatosCorreoAltBean datos){
		//mensaje de impresion de la accion realisada
		info("Ingresando a listar los correos ");
		List<DatosCorreoAltBean> correos = correo.Listar(datos);
		if(correos.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los correos");
			return new ResponseEntity<List<DatosCorreoAltBean>>(correos, HttpStatus.OK);
		}
	}
}
