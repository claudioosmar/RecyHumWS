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

import com.vector.BO.BODatosTelefonoAlt;
import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosTelefonoAltController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosTelefonoAltController extends Log {
	
	/** The telefono. */
	@Autowired
	private BODatosTelefonoAlt telefono;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosTelefonoAltBean>
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion crear datos telefono
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosTelefonoAltBean> datos){
		//Linea de impresion en consola que muestra datos de datos telefono al ser creados
		info("Se agrego el telefono "+datos.get(0).getTelefonoNw()+" al ID de persona "+datos.get(0).getIdpersona()+"\n ");
		return new ResponseEntity<MsgBean>(telefono.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion Modificar datos telefono
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosTelefonoAltBean datos){
		//Linea de impresion en consola que muestra datos de los idiomas al ser modificados
		info("Se modifico el telefono "+datos.getTelefonoNw()+" al ID de persona "+datos.getIdpersona()+"\n ");
		return new ResponseEntity<MsgBean>(telefono.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion eliminar datos telefono
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosTelefonoAltBean datos){
		//Linea de impresion en consola que muestra los datos telefono al ser eliminados
		info("Se elimino el telefono "+datos.getTelefonoNw()+"\n ");
		return new ResponseEntity<MsgBean>(telefono.Eliminar(datos.getTelefonoNw()),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion buscar datos telefono
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosTelefonoAltBean>buscar(@RequestBody DatosTelefonoAltBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		info("Se Listo el telefono "+datos.getTelefonoNw()+" al ID de persona "+datos.getIdpersona()+"\n ");
		return new ResponseEntity<DatosTelefonoAltBean>(telefono.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion listar los datos telefono
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosTelefonoAltBean>> consulta(@RequestBody DatosTelefonoAltBean datos){
		//mensaje de impresion de la accion realisada
		info("Ingresando a listar telefonos "+"\n" );
		List<DatosTelefonoAltBean> telefonos = telefono.Listar(datos.getIdpersona());
		if(telefonos.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los telefonos");
			return new ResponseEntity<List<DatosTelefonoAltBean>>(telefonos, HttpStatus.OK);
		}
	}
}
