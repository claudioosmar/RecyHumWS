/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.Model;

/**
 * @author Claudio
 *
 */
public interface DAODatosSesion {
	
	int Create(DatosInicioSesionBean datos);
	String Delete (int id);
	Model Buscar(DatosInicioSesionBean datos);
	List<DatosInicioSesionBean> Listar ();
	String VerificarLogin(DatosInicioSesionBean datos);

}
