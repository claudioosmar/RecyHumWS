/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosTelefonoAltBean;



/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosTelefonoAlt {
	//tipo de dato regresado por los beans de herramientas usadas
	int  Crear(DatosTelefonoAltBean datos);
	//tipo de dato regresado por los beans de herramientas usadas
	int  Modificar(DatosTelefonoAltBean datos);
	//tipo de dato regresado por los beans de herramientas usadas
	int  Eliminar(String id);
	//regresa un listado de busqueda de los datos de herramientas usadas bean
	DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos);
	List<DatosTelefonoAltBean> Listar(long id);
}
