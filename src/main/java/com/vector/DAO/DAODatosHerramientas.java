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
public interface DAODatosHerramientas {
	int  Crear(DatosHerramientasBean datos);
	int  Modificar(DatosHerramientasBean datos);
	int  Eliminar(DatosHerramientasBean datos);
	List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos);
	List<DatosHerramientasBean> Listar();
}
