/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosLogin.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public interface BODatosLogin  {
	
	/**
	 * Clase: ListarUsuarios 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	//REGRESA UN LISTADO DEL BEAN DE INICIO DE SESION
	List<DatosInicioSesionBean> ListarUsuarios (DatosPistaAuditoraBean pista);
	
	/**
	 * Clase: VerificarUsuario 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna list
	 */
	//REGRESA UN LISTADO DEL BEAN DE FORMULARIO
	List<DatosFormularioBean> VerificarUsuario(DatosInicioSesionBean datos);
	
	/**
	 * Clase: CreateUser 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE CREACION DE USUARIO QUE REGRESA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean CreateUser(DatosInicioSesionBean datos);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna msg bean
	 */
	//MENSAJE DE MODIFICACION DE DATOS DE INICIO DE SESION QUE REGRESA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosInicioSesionBean datos);
	
	/**
	 * Clase: Eliminar 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna msg bean
	 */
	//MENSAJE DE ELIMINACION DE DATOS DEL INICIO DE SESION QUE REGRESA UN MENSADE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosInicioSesionBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna datos inicio sesion bean
	 */
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL BEAN INICIO DE SESION
	DatosInicioSesionBean Buscar(DatosInicioSesionBean datos);
	
}
