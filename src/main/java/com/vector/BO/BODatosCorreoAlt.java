/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosCorreoAlt.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosCorreoAlt {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosCorreoAltBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE CORREOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosCorreoAltBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE CORREOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE CORREOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCorreoAltBean
	 * @return Retorna datos correo alt bean
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO DE CORREOALT
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	//REGRESA UN LISTADO DE LOS DATOS DEL APARTADO DE CORREOALT
	List<DatosCorreoAltBean> Listar(DatosCorreoAltBean datos);
	/**
	 * @param datos
	 * @return
	 */
	
}
