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
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosCurso {
	//tipo de dato regresado por los beans de cursos
	int  Crear(DatosCursoBean datos);
	//tipo de dato regresado por los beans de cursos
	int  Modificar(DatosCursoBean datos);
	//tipo de dato regresado por los beans de cursos
	int  Eliminar(DatosCursoBean datos);
	//regresa un listado de busqueda de los datos de cursos bean
	List<DatosCursoBean> Buscar(DatosCursoBean datos);
	List<DatosCursoBean> Listar();
}
