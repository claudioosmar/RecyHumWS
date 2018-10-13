/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosDocumentos.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosDocumentos {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosDocumentoBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE DATOS EN DOCUMENTOS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosDocumentoBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE DATOS EN DOCUMENTOS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosDocumentoBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE DATOS EN DOCUMENTOS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosDocumentoBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosDocumentoBean
	 * @return Retorna list
	 */
	//BUSQUEDA DE DATOS DE DOCUMENTOS
	List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	//LISTADO DE DATOS DE DOCUMENTOS
	List<DatosDocumentoBean> Listar(long id);
}
