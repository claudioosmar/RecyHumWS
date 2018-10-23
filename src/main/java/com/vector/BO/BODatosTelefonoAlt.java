/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosTelefonoAlt.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosTelefonoAlt {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosTelefonoAltBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE TELEFONOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosTelefonoAltBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE TELEFONOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosTelefonoAltBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido String
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE TELEFONOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosTelefonoAltBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosTelefonoAltBean
	 * @return Retorna datos telefono alt bean
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO TELEFONOALT
	DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	//REGRESA UN LISTADO DE LOS DATOS DEL APARTADO TELEFONOALT
	List<DatosTelefonoAltBean> Listar(DatosTelefonoAltBean datos);
}
