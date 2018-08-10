/**
 * 
 */
package com.vector.service;

import java.util.List;

import com.vector.model.Modelo;

/**
 * @author Claudio
 *
 */
public interface ModelABCLD<T> {
	
	String Create(T datos);
	String Delete (int id);
	Modelo Buscar(T datos);
	List<Modelo> Listar (T datos);

}
