/**
 * DAODatosCurso.java -- 25/08/2018
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCursoBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosCurso.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  11/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosCurso {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de cursos
	int  Crear(DatosCursoBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de cursos
	int  Modificar(DatosCursoBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de cursos
	int  Eliminar(DatosCursoBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de cursos bean
	List<DatosCursoBean> Buscar(DatosCursoBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosCursoBean> Listar();
}
