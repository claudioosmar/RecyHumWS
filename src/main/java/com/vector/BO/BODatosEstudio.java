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
	
	DatosEstudioBean Crear(List<DatosEstudioBean> datos);
	MsgBean Modificar(DatosEstudioBean datos);
	MsgBean Eliminar(DatosEstudioBean datos);
	List<DatosEstudioBean> Buscar(DatosEstudioBean datos);
	List<DatosEstudioBean> Listar();

}
