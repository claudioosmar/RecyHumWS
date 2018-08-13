/**
 * 
 */
package com.vector.interfaceModel;

import java.util.List;

/**
 * @author Claudio
 *
 */
public interface InterModelRepository<T> {
	
	String Create(T datos);
	String Delete (int id);
	InterModelBean Buscar(T datos);
	List<InterModelBean> Listar (T datos);

}
