/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.Beans.MsgBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosHerramientasUsadas.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosHerramientasUsadas {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosHerramientasUsadasBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DE EL APARTADO DE HERRAMIENTAS USADAS
	MsgBean Crear(List<DatosHerramientasUsadasBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna msg bean
	 */
	//MMENSAJE DE MODIFICACION DE LOS DATOS DE EL APARTADO DE HERRAMIENTAS USADAS
	MsgBean Modificar(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DE EL APARTADO DE HERRAMIENTAS USADAS
	MsgBean Eliminar(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosHerramientasUsadasBean
	 * @return Retorna list
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO HERRAMIENTAS USADAS
	List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//REGRESA UN LISTADO DE DATOS DEL APARTADO HERRAMIENTAS USADAS
	List<DatosHerramientasUsadasBean> Listar();
}
