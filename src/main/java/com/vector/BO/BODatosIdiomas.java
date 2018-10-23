/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosIdiomas.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosIdiomas {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosIdiomasBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO IDIOMAS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosIdiomasBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO IDIOMAS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosIdiomasBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO IDIOMAS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosIdiomasBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosIdiomasBean
	 * @return Retorna list
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS DE APARTADO IDIOMAS
	List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosIdiomasBean> Listar(DatosIdiomasBean datos);
}
