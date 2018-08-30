/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

/**
 * @author vectormx
 *
 */
public interface BODatosPersonales {
	
	DatosPersonalesBean Crear(DatosPersonalesBean datos);
	MsgBean Modificar(DatosPersonalesBean datos);
	MsgBean Eliminar (DatosPersonalesBean datos);
	DatosPersonalesBean Buscar(DatosPersonalesBean datos);
	List<DatosPersonalesBean> Listar ();

}
