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
public interface DAODatosSesion {
	
	int Create(DatosInicioSesionBean datos);
	int Delete (DatosInicioSesionBean datos);
	int Modificar (DatosInicioSesionBean datos);
	DatosInicioSesionBean Buscar(DatosInicioSesionBean datos);
	List<DatosInicioSesionBean> Listar ();
	List<DatosFormularioBean> VerificarLogin(DatosInicioSesionBean datos);

}
