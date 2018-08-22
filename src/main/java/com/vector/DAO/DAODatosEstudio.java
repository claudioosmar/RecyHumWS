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
public interface DAODatosEstudio {
	int  Crear(DatosEstudioBean datos);
	int  Modificar(DatosEstudioBean datos);
	int  Eliminar(int id);
	DatosEstudioBean Buscar(DatosEstudioBean datos);
	List<DatosEstudioBean> Listar();
}