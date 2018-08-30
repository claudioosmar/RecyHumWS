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
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosPersonales {
	//tipo de dato regresado por los beans de datos personales
	int Crear (DatosPersonalesBean datos);
	//tipo de dato regresado por los beans de datos personales
	int Modificar (DatosPersonalesBean datos);
	//tipo de dato regresado por los beans de datos personales
	int Eliminar (long id);
	//regresa un listado de busqueda de los datos de datos personales bean
	DatosPersonalesBean Buscar (DatosPersonalesBean datos);
	List<DatosPersonalesBean> Listar ();
}
