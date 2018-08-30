/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosEstudio {
	
	//RETORNO DE CREACION DE DATOS EN ESTUDIO
	DatosEstudioBean Crear(List<DatosEstudioBean> datos);
	//MENSAJE DE MODIFICACION DE DATOS EN ESTUDIO
	MsgBean Modificar(DatosEstudioBean datos);
	//MENSAJE DE ELIMINACION DE DATOS EN ESTUDIO
	MsgBean Eliminar(DatosEstudioBean datos);
	//REGRESO DE BUSQUEDA DE DATOS DE ESTUDIO
	List<DatosEstudioBean> Buscar(DatosEstudioBean datos);
	//LISTADO DE DATOS DE ESTUDIO
	List<DatosEstudioBean> Listar();

}
