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
	
	MsgBean Crear(DatosEstudioBean datos);
	MsgBean Modificar(DatosEstudioBean datos);
	MsgBean Eliminar(int id);
	DatosEstudioBean Buscar(DatosEstudioBean datos);
	List<DatosEstudioBean> Listar();

}
