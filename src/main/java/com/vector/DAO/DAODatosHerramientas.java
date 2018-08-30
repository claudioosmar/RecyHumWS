/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosHerramientasBean;


/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosHerramientas {
	//tipo de dato regresado por los beans de herramientas
	int  Crear(DatosHerramientasBean datos);
	//tipo de dato regresado por los beans de herramientas
	int  Modificar(DatosHerramientasBean datos);
	//tipo de dato regresado por los beans de herramientas
	int  Eliminar(DatosHerramientasBean datos);
	//regresa un listado de busqueda de los datos de herramientas bean
	List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos);
	List<DatosHerramientasBean> Listar();
}
