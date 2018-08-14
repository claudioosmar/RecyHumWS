/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.BeanInicioSesion;
import com.vector.Beans.Model;

/**
 * @author Claudio
 *
 */
public interface SesionDAO {
	
	String Create(BeanInicioSesion datos);
	String Delete (int id);
	Model Buscar(BeanInicioSesion datos);
	List<BeanInicioSesion> Listar ();

}
