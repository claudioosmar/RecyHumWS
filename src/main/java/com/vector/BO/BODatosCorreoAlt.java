/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;

/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
public interface BODatosCorreoAlt {
	MsgBean Crear(List<DatosCorreoAltBean> datos);
	MsgBean Modificar(DatosCorreoAltBean datos);
	MsgBean Eliminar(String id);
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	List<DatosCorreoAltBean> Listar(long id);
}
