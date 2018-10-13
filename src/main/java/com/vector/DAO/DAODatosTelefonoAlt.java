/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosTelefonoAltBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosTelefonoAlt.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosTelefonoAlt {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas usadas
	int  Crear(DatosTelefonoAltBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas usadas
	int  Modificar(DatosTelefonoAltBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido String
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas usadas
	int  Eliminar(String id);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna datos telefono alt bean
	 */
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosTelefonoAltBean> Listar(long id);
}
