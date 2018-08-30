/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosHerramientasUsadas {
	//MENSAJE DE CREACION DE LOS DATOS DE EL APARTADO DE HERRAMIENTAS USADAS
	MsgBean Crear(List<DatosHerramientasUsadasBean> datos);
	//MMENSAJE DE MODIFICACION DE LOS DATOS DE EL APARTADO DE HERRAMIENTAS USADAS
	MsgBean Modificar(DatosHerramientasUsadasBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DE EL APARTADO DE HERRAMIENTAS USADAS
	MsgBean Eliminar(DatosHerramientasUsadasBean datos);
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO HERRAMIENTAS USADAS
	List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos);
	//REGRESA UN LISTADO DE DATOS DEL APARTADO HERRAMIENTAS USADAS
	List<DatosHerramientasUsadasBean> Listar();
}
