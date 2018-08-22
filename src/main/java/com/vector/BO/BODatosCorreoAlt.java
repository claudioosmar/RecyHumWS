/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosCorreoAlt {
	MsgBean Crear(DatosCorreoAltBean datos);
	MsgBean Modificar(DatosCorreoAltBean datos);
	MsgBean Eliminar(int id);
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	List<DatosCorreoAltBean> Listar();
}
