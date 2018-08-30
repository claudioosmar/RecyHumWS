/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;



/**
 * @author Claudio
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosSesion {
	//tipo de dato regresado por los beans de inicio de sesion
	int Create(DatosInicioSesionBean datos);
	//tipo de dato regresado por los beans de inicio de sesion
	int Delete (DatosInicioSesionBean datos);
	//tipo de dato regresado por los beans de inicio de sesion
	int Modificar (DatosInicioSesionBean datos);
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	DatosInicioSesionBean Buscar(DatosInicioSesionBean datos);
	List<DatosInicioSesionBean> Listar ();
	List<DatosFormularioBean> VerificarLogin(DatosInicioSesionBean datos);

}
