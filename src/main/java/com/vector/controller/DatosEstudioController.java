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

import com.vector.BO.BODatosEstudio;
import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosEstudioController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosEstudioController extends Log{
	
	
	/** The estudio. */
	@Autowired
	private BODatosEstudio estudio;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosEstudioBean>
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Crear", method = RequestMethod.POST)
	public ResponseEntity<DatosEstudioBean> insertar(@RequestBody List<DatosEstudioBean> datos){
		info("se creo un nuevo estudio: "+datos.get(0).getIdestudio());
		return new ResponseEntity<DatosEstudioBean>(estudio.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosEstudioBean datos){
		info("Se modifico el estudio "+datos.getIdestudio());
		return new ResponseEntity<MsgBean>(estudio.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosEstudioBean datos){
		info("se elimino el estudio con id carrera "+datos.getIdcarrera()+"e id educacion "+datos.getIdestudio());
		return new ResponseEntity<MsgBean>(estudio.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosEstudioBean>>buscar(@RequestBody DatosEstudioBean datos){
		info("se busco los estudios de la persona "+datos.getIdpersona());
		return new ResponseEntity<List<DatosEstudioBean>>(estudio.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosEstudioBean>> consulta(@RequestBody DatosEstudioBean datos ){
		info("Ingresando a estudios");
		List<DatosEstudioBean> estudios = estudio.Listar();
		if(estudios.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los estudios");
			return new ResponseEntity<List<DatosEstudioBean>>(estudios, HttpStatus.OK);
		}
	}
}
