/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosHerramientas {
	//MENSAJE DE CREACION DE LOS DATOS DE HERRAMIENTAS
	MsgBean Crear(List<DatosHerramientasBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DE HERRAMIENTAS
	MsgBean Modificar(DatosHerramientasBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DE HERRAMIENTAS
	MsgBean Eliminar(DatosHerramientasBean datos);
	//REGRESA UNA BUSQUEDA DE LOS DATOS HERRAMIENTAS
	List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos);
	//LISTADO DE DATOS DE HERRAMIENTAS
	List<DatosHerramientasBean> Listar();
}
