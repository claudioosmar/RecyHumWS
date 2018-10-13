/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosLaborales.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosLaborales {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosLaboralesBean>
	 * @return Retorna datos laborales bean
	 */
	//RETORNO DE DATOS DE LA CREACION DE DATOS LABORALES
	DatosLaboralesBean Crear(List<DatosLaboralesBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosLaboralesBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS LABORALES
	MsgBean Modificar(DatosLaboralesBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido int
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS LABORALES
	MsgBean Eliminar(int id);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosLaboralesBean
	 * @return Retorna list
	 */
	//REGRESO DE BUSQUEDA DE LOS DATOS LABORAES
	List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//LISTADO DE DATOS LABORALES
	List<DatosLaboralesBean> Listar();
}
