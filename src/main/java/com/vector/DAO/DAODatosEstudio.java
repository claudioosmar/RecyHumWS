/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosEstudioBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosEstudio.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosEstudio {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna long
	 */
	//tipo de dato regresado por los beans de estudios
	long  Crear(DatosEstudioBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de estudios
	int  Modificar(DatosEstudioBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de estudios
	int  Eliminar(DatosEstudioBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	List<DatosEstudioBean> Buscar(DatosEstudioBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosEstudioBean> Listar();
}
