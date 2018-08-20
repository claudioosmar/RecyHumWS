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
public interface DAODatosIdiomas {
	String Crear(DatosIdiomasBean datos);
	String Modificar(DatosIdiomasBean datos);
	String Eliminar(int id);
	DatosIdiomasBean Buscar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Listar();
}
