/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosHerramientas.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosHerramientas {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosHerramientasBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DE HERRAMIENTAS
	MsgBean Crear(List<DatosHerramientasBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DE HERRAMIENTAS
	MsgBean Modificar(DatosHerramientasBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DE HERRAMIENTAS
	MsgBean Eliminar(DatosHerramientasBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasBean
	 * @return Retorna list
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS HERRAMIENTAS
	List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//LISTADO DE DATOS DE HERRAMIENTAS
	List<DatosHerramientasBean> Listar();
}
