/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosLaborales {
	//RETORNO DE DATOS DE LA CREACION DE DATOS LABORALES
	DatosLaboralesBean Crear(List<DatosLaboralesBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS LABORALES
	MsgBean Modificar(DatosLaboralesBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS LABORALES
	MsgBean Eliminar(int id);
	//REGRESO DE BUSQUEDA DE LOS DATOS LABORAES
	List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos);
	//LISTADO DE DATOS LABORALES
	List<DatosLaboralesBean> Listar();
}
