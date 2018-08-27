/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosIdiomas {
	MsgBean Crear(List<DatosIdiomasBean> datos);
	MsgBean Modificar(DatosIdiomasBean datos);
	MsgBean Eliminar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Listar();
}
