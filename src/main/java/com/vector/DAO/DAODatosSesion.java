/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosSesion.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar y verificar
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosSesion {
	
	/**
	 * Clase: Create 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de inicio de sesion
	int Create(DatosInicioSesionBean datos);
	
	/**
	 * Clase: Delete 
	 * Descripcion:.
	 *
	 * @param id Tipo de Dato resivido long
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de inicio de sesion
	int Delete (long id);
	
	/**
	 * Clase: Modificar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna int
	 */
	//tipo de dato regresado por los beans de inicio de sesion
	int Modificar (DatosInicioSesionBean datos);
	
	/**
	 * Clase: Buscar 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna datos inicio sesion bean
	 */
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	DatosInicioSesionBean Buscar(DatosInicioSesionBean datos);
	
	/**
	 * Clase: Listar 
	 * Descripcion:.
	 *
	 * @return Retorna list
	 */
	List<DatosInicioSesionBean> Listar ();
	
	/**
	 * Clase: VerificarLogin 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido DatosInicioSesionBean
	 * @return Retorna list
	 */
	List<DatosFormularioBean> VerificarLogin(DatosInicioSesionBean datos);

}
