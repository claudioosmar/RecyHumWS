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
public interface DAODatosHerramientasUsadas {
	int  Crear(DatosHerramientasUsadasBean datos);
	int  Modificar(DatosHerramientasUsadasBean datos);
	int  Eliminar(DatosHerramientasUsadasBean datos);
	List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos);
	List<DatosHerramientasUsadasBean> Listar();
}
