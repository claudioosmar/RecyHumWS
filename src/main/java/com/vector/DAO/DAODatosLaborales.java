/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosLaboralesBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosLaborales.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosLaborales {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosLaboralesBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos laborales
	int  Crear(DatosLaboralesBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosLaboralesBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos laborales
	int  Modificar(DatosLaboralesBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido int
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos laborales
	int  Eliminar(int id);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosLaboralesBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de datos laborales bean
	List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosLaboralesBean> Listar();
}
