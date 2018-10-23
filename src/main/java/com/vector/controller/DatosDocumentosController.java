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

import com.vector.BO.BODatosDocumentos;
import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosDocumentosController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosDocumentosController extends Log{
	
	/** The documento. */
	@Autowired
	private BODatosDocumentos documento;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosDocumentoBean>
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion crear documento
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosDocumentoBean> datos){
		//Linea de impresion en consola que muestra datos del documento al ser creado
		info("Se agrego el doc "+datos.toString());
		return new ResponseEntity<MsgBean>(documento.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion Modificar documentos
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosDocumentoBean datos){
		//Ruta utilizada para la llamada de la funcion Modificar documentos
		info("Se modifico el documento "+datos.getDescripciondocNw()+" con id "+datos.getIddocumentoLt()+" " + "al ID de persona "+datos.getIdpersona()+" con id nuevo documento "+datos.getIddocumentoNw()+" ");
		return new ResponseEntity<MsgBean>(documento.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion eliminar documetos
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosDocumentoBean datos){
		//Linea de impresion en consola que muestra datos de los documentos al ser eliminados
		info("se elimino el documento "+datos.getDescripciondocNw()+ "con el ID de documento "+datos.getIddocumentoNw());
		return new ResponseEntity<MsgBean>(documento.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion buscar documentos
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosDocumentoBean>>buscar(@RequestBody DatosDocumentoBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		info("se busco el documento "+datos.toString());
		return new ResponseEntity<List<DatosDocumentoBean>>(documento.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion listar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosDocumentoBean>> consulta(@RequestBody DatosDocumentoBean datos){
		//mensaje de impresion de la accion realisada
		info("Ingresando a listar documento ");
		List<DatosDocumentoBean> documentos = documento.Listar(datos);
		if(documentos.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los documentos");
			return new ResponseEntity<List<DatosDocumentoBean>>(documentos, HttpStatus.OK);
		}
	}
}
