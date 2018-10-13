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

import com.vector.BO.BODatosHerramientasUsadas;
import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosHerramientasUsadasController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosHerramientasUsadasController  extends Log{
	
	/** The herramientasus. */
	@Autowired
	private BODatosHerramientasUsadas herramientasus;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosHerramientasUsadasBean>
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosHerramientasUsadasBean> datos){
		info("Se agrego herramienta usadas "+datos.get(0).getIdherramienta()+"\n ");
		return new ResponseEntity<MsgBean>(herramientasus.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosHerramientasUsadasBean datos){
		info("Se actualizo herramienta usadas "+datos.getNombreherramienta()+"con id "+datos.getIdherramienta()+"\n ");
		return new ResponseEntity<MsgBean>(herramientasus.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosHerramientasUsadasBean datos){
		info("Se elimino herramienta usada con id "+datos.getIdherramienta()+"y persona id "+datos.getIdexplaboral()+"\n ");
		return new ResponseEntity<MsgBean>(herramientasus.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasUsadasBean>>buscar(@RequestBody DatosHerramientasUsadasBean datos){
		info("Se buscaron las herramientas usadas en el trabajo "+datos.getIdherramienta()+" y experiencia con id "+datos.getIdexplaboral()+"\n ");
		return new ResponseEntity<List<DatosHerramientasUsadasBean>>(herramientasus.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasUsadasBean>> consulta(@RequestBody DatosHerramientasUsadasBean datos){
		info("Se listaton herramientas usadas"+"\n ");
		List<DatosHerramientasUsadasBean> herramientaus = herramientasus.Listar();
		if(herramientaus.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron las herramientas usadas");
			return new ResponseEntity<List<DatosHerramientasUsadasBean>>(herramientaus, HttpStatus.OK);
		}
	}
}
