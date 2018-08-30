/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCorreoAltBean;


/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosCorreoAlt {
	//tipo de dato regresado por los beans de correoalt bean
	int  Crear(DatosCorreoAltBean datos);
	//tipo de dato regresado por los beans de correoalt bean
	int  Modificar(DatosCorreoAltBean datos);
	//tipo de dato regresado por los beans de correoalt bean
	int  Eliminar(DatosCorreoAltBean datos);
	//regresa un listado de busqueda de los datos de correoalt bean
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	List<DatosCorreoAltBean> Listar(long id);
}
