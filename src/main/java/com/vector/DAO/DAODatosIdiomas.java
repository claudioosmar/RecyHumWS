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
	int Crear(DatosIdiomasBean datos);
	int Modificar(DatosIdiomasBean datos);
	int Eliminar(int id);
	DatosIdiomasBean Buscar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Listar();
}