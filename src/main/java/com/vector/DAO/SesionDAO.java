/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.Model;

/**
 * @author Claudio
 *
 */
public interface SesionDAO<T> {
	
	String Create(T datos);
	String Delete (int id);
	Model Buscar(T datos);
	List<T> Listar ();

}
