/**
 * 
 */
package com.vector.BO;

import java.util.List;

/**
 * @author vectormx
 *
 */
public interface LoginBO<T>  {
	List<T> ListarUsuarios ();
	String VerificarUsuario(T datos);
	T CreateUser(T datos);
	
}
