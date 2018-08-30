/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosLaboralesBean;


/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosLaborales {
	//tipo de dato regresado por los beans de datos laborales
	int  Crear(DatosLaboralesBean datos);
	//tipo de dato regresado por los beans de datos laborales
	int  Modificar(DatosLaboralesBean datos);
	//tipo de dato regresado por los beans de datos laborales
	int  Eliminar(int id);
	//regresa un listado de busqueda de los datos de datos laborales bean
	List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos);
	List<DatosLaboralesBean> Listar();
}
