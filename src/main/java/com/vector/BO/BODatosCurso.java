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
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE CURSO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosCursoBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO CURSO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosCursoBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE CURSO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosCursoBean datos);
	//BUSQUEDA DE DATOS DEL APARTADO CURSO
	List<DatosCursoBean> Buscar(DatosCursoBean datos);
	//LISTADO DE DATOS DEL APARTADO CURSO
	List<DatosCursoBean> Listar();
}
