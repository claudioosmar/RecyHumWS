/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosPersonales.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosPersonales {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos personales
	int Crear (DatosPersonalesBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos personales
	int Modificar (DatosPersonalesBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos personales
	int Eliminar (long id);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna datos personales bean
	 */
	//regresa un listado de busqueda de los datos de datos personales bean
	DatosPersonalesBean Buscar (DatosPersonalesBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//Lista de los datos personales basicos
	List<DatosPersonalesBean> Listar ();
	
	/**
	 * Clase: Modificar2 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos personales
	int Modificar2(DatosPersonalesBean datos);
	
	/**
	 * Clase: Modificar3 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de datos personales
	int Modificar3(DatosPersonalesBean datos);
	
	/**
	 * Clase: BusquedaEstudiosPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaEstudiosPersona(long id);
	
	/**
	 * Clase: BusquedaHerramientasConPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaHerramientasConPersona(long id);
	
	/**
	 * Clase: BusquedaExpLaboralPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaExpLaboralPersona(long id);
	
	/**
	 * Clase: BusquedaIdiomasPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaIdiomasPersona(long id);
	
	/**
	 * Clase: BusquedaPersonaNombreCompleto 
	 * Descripcion:.
	 *
	 * @param parametro Tipo de Dato resivido String
	 * @return Retorna list
	 */
	List<DatosPersonalesBean> BusquedaPersonaNombreCompleto(String parametro);
	
}
