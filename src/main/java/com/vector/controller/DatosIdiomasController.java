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

import com.vector.BO.BODatosIdiomas;
import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosIdiomasController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  18/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: arreglo de mensaje para el LOG
 *   
 */
@RestController
public class DatosIdiomasController extends Log{

	/** The idioma. */
	@Autowired
	private BODatosIdiomas idioma;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosIdiomasBean>
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosIdiomas/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosIdiomasBean> datos){
		info("Se agrego el idioma "+datos.get(0).getIdidioma()+" al ID de persona "+datos.get(0).getIdpersona()+"\n ");
		return new ResponseEntity<MsgBean>(idioma.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosIdiomas/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosIdiomasBean datos){
		info("Se actializo el idioma"+"\n");
		return new ResponseEntity<MsgBean>(idioma.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path = "/SGRHWebService/DatosIdiomas/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosIdiomasBean datos){
		info("Se elimino el idioma "+"\n");
		return new ResponseEntity<MsgBean>(idioma.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna response entity
	 */
	@RequestMapping(path =  "/SGRHWebService/DatosIdiomas/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosIdiomasBean>>buscar(@RequestBody DatosIdiomasBean datos){
		info("Se listo los idiomas de la persona"+"\n");
		return new ResponseEntity<List<DatosIdiomasBean>>(idioma.Buscar(datos),HttpStatus.OK);
	}
	
    /**
     * Clase: consulta 
     * Descripcion:.
     *
     * @param datos Tipo de Dato resivido DatosIdiomasBean
     * @return Retorna response entity
     */
    @RequestMapping(value = "/SGRHWebService/DatosIdiomas/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosIdiomasBean>> consulta(@RequestBody DatosIdiomasBean datos){
		info("Ingresando a listar idiomas "+"\n");
		List<DatosIdiomasBean> idiomas = idioma.Listar(datos);
		if(idiomas.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los idiomas");
			return new ResponseEntity<List<DatosIdiomasBean>>(idiomas, HttpStatus.OK);
		}
	}
}
