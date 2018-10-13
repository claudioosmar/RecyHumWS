/**
 * BODatosCurso.java -- 25/08/2018
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCursoBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosCurso.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosCurso {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosCursoBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE CURSO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosCursoBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO CURSO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosCursoBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE CURSO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosCursoBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCursoBean
	 * @return Retorna list
	 */
	//BUSQUEDA DE DATOS DEL APARTADO CURSO
	List<DatosCursoBean> Buscar(DatosCursoBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//LISTADO DE DATOS DEL APARTADO CURSO
	List<DatosCursoBean> Listar();
}
