/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCorreoAltBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosCorreoAlt.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosCorreoAlt {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de correoalt bean
	int  Crear(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de correoalt bean
	int  Modificar(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de correoalt bean
	int  Eliminar(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna datos correo alt bean
	 */
	//regresa un listado de busqueda de los datos de correoalt bean
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosCorreoAltBean> Listar(long id);
}
