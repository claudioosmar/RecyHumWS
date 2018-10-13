/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosDocumentoBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosDocumento.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosDocumento {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de docuemntos
	int  Crear(DatosDocumentoBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de docuemntos
	int  Modificar(DatosDocumentoBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de docuemntos
	int  Eliminar(DatosDocumentoBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de documentos bean
	List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosDocumentoBean> Listar(long id);
}
