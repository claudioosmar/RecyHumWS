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

import com.vector.BO.BODatosHerramientas;
import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosHerramientasController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosHerramientasController extends Log{
	
	/** The herramientas. */
	@Autowired
	private BODatosHerramientas herramientas;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosHerramientasBean>
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientas/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosHerramientasBean> datos){
		info("Se agrego herramienta conocida "+datos.get(0).getIdherramienta()+" despc:"+datos.get(0).getDescripcionherra()+" añosexp:"+datos.get(0).getAnosexpherra()+"\n ");
		return new ResponseEntity<MsgBean>(herramientas.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientas/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosHerramientasBean datos){
		info("Se actualizo herramienta conocida "+datos.getNombreherramienta()+"con id "+datos.getIdherramienta()+"\n ");
		return new ResponseEntity<MsgBean>(herramientas.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientas/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosHerramientasBean datos){
		info("Se elimino herramienta conocida con id "+datos.getIdherramienta()+" y persona id "+datos.getIdpersona()+"\n ");
		return new ResponseEntity<MsgBean>(herramientas.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientas/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasBean>>buscar(@RequestBody DatosHerramientasBean datos){
		info("Se buscaron las herramientas conocidas con id de persona "+datos.getIdpersona()+"\n ");
		return new ResponseEntity<List<DatosHerramientasBean>>(herramientas.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientas/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasBean>> consulta(@RequestBody DatosHerramientasBean datos){
		info("Se listaton herramientas conocidas "+"\n ");
		List<DatosHerramientasBean> herramienta = herramientas.Listar();
		if(herramienta.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron las herramientas");
			return new ResponseEntity<List<DatosHerramientasBean>>(herramienta, HttpStatus.OK);
		}
	}
}
