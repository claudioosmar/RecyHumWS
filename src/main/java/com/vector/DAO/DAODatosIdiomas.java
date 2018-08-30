/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosIdiomasBean;

/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosIdiomas {
	//tipo de dato regresado por los beans de idiomas
	int Crear(DatosIdiomasBean datos);
	//tipo de dato regresado por los beans de idiomas
	int Modificar(DatosIdiomasBean datos);
	//tipo de dato regresado por los beans de idiomas
	int Eliminar(DatosIdiomasBean datos);
	//regresa un listado de busqueda de los datos de idiomas bean
	List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Listar();
}
