/**
 * DAODatosCurso.java -- 25/08/2018
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCursoBean;

/**
 * @author Jair
 *
 */
public interface DAODatosCurso {
	int  Crear(DatosCursoBean datos);
	int  Modificar(DatosCursoBean datos);
	int  Eliminar(DatosCursoBean datos);
	List<DatosCursoBean> Buscar(DatosCursoBean datos);
	List<DatosCursoBean> Listar();
}
