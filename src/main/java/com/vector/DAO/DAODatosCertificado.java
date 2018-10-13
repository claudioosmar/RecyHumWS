/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCertificadoBean;



// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosCertificado.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosCertificado {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de certificado
	int  Crear(DatosCertificadoBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de certificado
	int  Modificar(DatosCertificadoBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de certificado
	int  Eliminar(DatosCertificadoBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna list
	 */
	//regresa un listado de busqueda de los datos de certificado
	List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosCertificadoBean> Listar();
}
