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
	MsgBean Crear(DatosLaboralesBean datos);
	MsgBean Modificar(DatosLaboralesBean datos);
	MsgBean Eliminar(int id);
	DatosLaboralesBean Buscar(DatosLaboralesBean datos);
	List<DatosLaboralesBean> Listar();
}
