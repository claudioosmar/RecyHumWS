/**
 * DatosCursoController.java -- 25/08/2018
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

import com.vector.BO.BODatosCurso;
import com.vector.Beans.DatosCursoBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosCursoController.java
 *   Descripción:  contiene los links de los servicios disponibles
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@RestController
public class DatosCursoController extends Log{
	
	/** The curso. */
	@Autowired
	private BODatosCurso curso;
	
	/**
	 * Clase: insertar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosCursoBean>
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion crear cursos
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosCursoBean> datos){
		//Linea de impresion en consola que muestra datos de los cursos al ser creados
		info("Se creo un curso: IDCURSO["+datos.get(0).getIdcurso()+"]");
		return new ResponseEntity<MsgBean>(curso.Crear(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: actualizar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion Modificar cursos
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody  DatosCursoBean datos){
		//Linea de impresion en consola que muestra datos de los cursos al ser modificados
		info("Se modifico un curso con id: IDCURSO["+datos.getIdcurso()+"], IDCERTIFICADO["+datos.getIdcertificado()+"]");
		return new ResponseEntity<MsgBean>(curso.Modificar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion eliminar cursos
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosCursoBean datos){
		//Linea de impresion en consola que muestra datos de los cursos al ser eliminados
		info("se elimino un curso con id: IDCURSO["+datos.getIdcurso()+"]");
		return new ResponseEntity<MsgBean>(curso.Eliminar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion buscar cursos
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCursoBean>>buscar(@RequestBody  DatosCursoBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		info("se busco los cursos de la persona: IDPERSONA["+datos.getIdpersona()+"]");
		return new ResponseEntity<List< DatosCursoBean>>(curso.Buscar(datos),HttpStatus.OK);
	}
	
	/**
	 * Clase: consulta 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna response entity
	 */
	//Ruta utilizada para la llamada de la funcion listar cursos
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCursoBean>> consulta(@RequestBody DatosCursoBean datos){
		//mensaje de impresion de la accion realisada
		info("Ingresando a listar cursos ");
		List<DatosCursoBean> cursos = curso.Listar();
		if(cursos.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los cursos");
			return new ResponseEntity<List<DatosCursoBean>>(cursos, HttpStatus.OK);
		}
	}
}
