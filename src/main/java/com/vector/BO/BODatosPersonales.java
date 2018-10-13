/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosPersonales.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosPersonales {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna datos personales bean
	 */
	//CREACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE DATOSPERSONALESBEAN
	DatosPersonalesBean Crear(DatosPersonalesBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosPersonalesBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELINACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar (DatosPersonalesBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna datos personales bean
	 */
	//BUSQUEDA DE DATOS DEL APARTADO DE DATOS PERSONALES
	DatosPersonalesBean Buscar(DatosPersonalesBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//LISTADO DE DATOS DEL APARTADI DE DATOS PERSONALES
	List<DatosPersonalesBean> Listar ();
	
	/**
	 * Clase: Modificar2 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN V2
	MsgBean Modificar2(DatosPersonalesBean datos);
	
	/**
	 * Clase: Modificar3 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosPersonalesBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES SALARIO/STATUS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN V2
	MsgBean Modificar3(DatosPersonalesBean datos);
		
	/**
	 * Clase: BusquedaEstudiosPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaEstudiosPersona(long id);
	
	/**
	 * Clase: BusquedaHerramientasConPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaHerramientasConPersona(long id);
	
	/**
	 * Clase: BusquedaExpLaboralPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaExpLaboralPersona(long id);
	
	/**
	 * Clase: BusquedaIdiomasPersona 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna list
	 */
	List<DatosPersonalesBean>BusquedaIdiomasPersona(long id);
	
	/**
	 * Clase: BusquedaNombreCompleto 
	 * Descripcion:.
	 *
	 * @param parametro Tipo de Dato resivido String
	 * @return Retorna list
	 */
	List<DatosPersonalesBean> BusquedaNombreCompleto(String parametro);

}
