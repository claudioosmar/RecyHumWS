/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

/**
 * @author vectormx
 *
 */
public interface DAODatosPersonales {

	int Crear (DatosPersonalesBean datos);
	int Modificar (DatosPersonalesBean datos);
	String Eliminar (int id);
	DatosPersonalesBean Buscar (DatosPersonalesBean datos);
	List<DatosPersonalesBean> Listar ();
	
}
