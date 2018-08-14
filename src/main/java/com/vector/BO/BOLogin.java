/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.InicioSesionBean;

/**
 * @author vectormx
 *
 */
public interface BOLogin  {
	List<InicioSesionBean> ListarUsuarios ();
	String VerificarUsuario(InicioSesionBean datos);
	InicioSesionBean CreateUser(InicioSesionBean datos);
	
}
