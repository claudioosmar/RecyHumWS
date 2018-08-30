/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosHerramientasUsadasBean;



/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosHerramientasUsadas {
	//tipo de dato regresado por los beans de herramientas usadas
	int  Crear(DatosHerramientasUsadasBean datos);
	//tipo de dato regresado por los beans de herramientas usadas
	int  Modificar(DatosHerramientasUsadasBean datos);
	//tipo de dato regresado por los beans de herramientas usadas
	int  Eliminar(DatosHerramientasUsadasBean datos);
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos);
	List<DatosHerramientasUsadasBean> Listar();
}
