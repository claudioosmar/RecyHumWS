/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.MsgBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosEstudio.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosEstudio {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosEstudioBean>
	 * @return Retorna datos estudio bean
	 */
	//RETORNO DE CREACION DE DATOS EN ESTUDIO
	DatosEstudioBean Crear(List<DatosEstudioBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE DATOS EN ESTUDIO
	MsgBean Modificar(DatosEstudioBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE DATOS EN ESTUDIO
	MsgBean Eliminar(DatosEstudioBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosEstudioBean
	 * @return Retorna list
	 */
	//REGRESO DE BUSQUEDA DE DATOS DE ESTUDIO
	List<DatosEstudioBean> Buscar(DatosEstudioBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//LISTADO DE DATOS DE ESTUDIO
	List<DatosEstudioBean> Listar(DatosEstudioBean datos);

}
