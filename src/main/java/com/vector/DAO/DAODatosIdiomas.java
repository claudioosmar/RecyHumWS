/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosIdiomasBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosIdiomas.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosIdiomas {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de idiomas
	int Crear(DatosIdiomasBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de idiomas
	int Modificar(DatosIdiomasBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de idiomas
	int Eliminar(DatosIdiomasBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de idiomas bean
	List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosIdiomasBean> Listar();
}
