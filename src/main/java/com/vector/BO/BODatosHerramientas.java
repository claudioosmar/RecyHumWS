/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosHerramientas {
	MsgBean Crear(List<DatosHerramientasBean> datos);
	MsgBean Modificar(DatosHerramientasBean datos);
	MsgBean Eliminar(DatosHerramientasBean datos);
	List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos);
	List<DatosHerramientasBean> Listar();
}
