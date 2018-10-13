/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosHerramientasUsadasBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosHerramientasUsadas.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosHerramientasUsadas {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas usadas
	int  Crear(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas usadas
	int  Modificar(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de herramientas usadas
	int  Eliminar(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosHerramientasUsadasBean> Listar();
}
