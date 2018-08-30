/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosEstudioBean;

/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosEstudio {
	//tipo de dato regresado por los beans de estudios
	long  Crear(DatosEstudioBean datos);
	//tipo de dato regresado por los beans de estudios
	int  Modificar(DatosEstudioBean datos);
	//tipo de dato regresado por los beans de estudios
	int  Eliminar(DatosEstudioBean datos);
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	List<DatosEstudioBean> Buscar(DatosEstudioBean datos);
	List<DatosEstudioBean> Listar();
}
