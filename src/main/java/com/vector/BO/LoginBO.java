/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.BeanInicioSesion;

/**
 * @author vectormx
 *
 */
public interface LoginBO  {
	List<BeanInicioSesion> ListarUsuarios ();
	String VerificarUsuario(BeanInicioSesion datos);
	BeanInicioSesion CreateUser(BeanInicioSesion datos);
	
}
