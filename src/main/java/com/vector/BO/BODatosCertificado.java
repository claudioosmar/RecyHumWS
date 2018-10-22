/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosCertificado.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 *
 * @author vectormx
 */
//INTERFAZ PARA EL BO DE DATOS CERTIFICADO
public interface BODatosCertificado {
	
	/**
	 * Clase: Crear 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido List<DatosCertificadoBean>
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE CERTIFICADO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosCertificadoBean> datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE CERTIFICADO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosCertificadoBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE CERTIFICADO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosCertificadoBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosCertificadoBean
	 * @return Retorna list
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO DE CERTIFICADO
	List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//REGRESA UN LISTADO DE LOS DATOS DEL APARTADO CERTIFICADO 
	List<DatosCertificadoBean> Listar(DatosInicioSesionBean datos);
}
