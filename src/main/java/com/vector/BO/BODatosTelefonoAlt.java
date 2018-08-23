/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosTelefonoAlt {
	MsgBean Crear(DatosTelefonoAltBean datos);
	MsgBean Modificar(DatosTelefonoAltBean datos);
	MsgBean Eliminar(String id);
	DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos);
	List<DatosTelefonoAltBean> Listar(long id);
}
