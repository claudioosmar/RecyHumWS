/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCorreoAltBean;



/**
 * @author vectormx
 *
 */
public interface DAODatosCorreoAlt {
	int  Crear(DatosCorreoAltBean datos);
	int  Modificar(DatosCorreoAltBean datos);
	int  Eliminar(int id);
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	List<DatosCorreoAltBean> Listar();
}
