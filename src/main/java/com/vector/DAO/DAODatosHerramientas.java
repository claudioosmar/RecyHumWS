/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosHerramientasBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosHerramientas.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosHerramientas {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas
	int  Crear(DatosHerramientasBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas
	int  Modificar(DatosHerramientasBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas
	int  Eliminar(DatosHerramientasBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de herramientas bean
	List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosHerramientasBean> Listar();
}
