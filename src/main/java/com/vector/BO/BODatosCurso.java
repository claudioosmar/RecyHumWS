/**
 * BODatosCurso.java -- 25/08/2018
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCursoBean;
import com.vector.Beans.MsgBean;

/**
 * @author Jair
 *
 */
public interface BODatosCurso {
	MsgBean Crear(List<DatosCursoBean> datos);
	MsgBean Modificar(DatosCursoBean datos);
	MsgBean Eliminar(DatosCursoBean datos);
	List<DatosCursoBean> Buscar(DatosCursoBean datos);
	List<DatosCursoBean> Listar();
}
