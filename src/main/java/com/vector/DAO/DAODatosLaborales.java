/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosLaboralesBean;


/**
 * @author vectormx
 *
 */
public interface DAODatosLaborales {
	int  Crear(DatosLaboralesBean datos);
	int  Modificar(DatosLaboralesBean datos);
	int  Eliminar(int id);
	List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos);
	List<DatosLaboralesBean> Listar();
}
