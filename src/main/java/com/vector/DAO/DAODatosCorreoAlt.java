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
public interface DAODatosCorreoAlt {
	int  Crear(DatosCorreoAltBean datos);
	int  Modificar(DatosCorreoAltBean datos);
	int  Eliminar(String id);
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	List<DatosCorreoAltBean> Listar(long id);
}
