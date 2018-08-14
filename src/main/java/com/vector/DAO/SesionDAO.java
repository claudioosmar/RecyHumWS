/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.InicioSesionBean;
import com.vector.Beans.Model;

/**
 * @author Claudio
 *
 */
public interface SesionDAO {
	
	String Create(InicioSesionBean datos);
	String Delete (int id);
	Model Buscar(InicioSesionBean datos);
	List<InicioSesionBean> Listar ();
	String VerificarLogin(InicioSesionBean datos);

}
