/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosHerramientasUsadas {
	MsgBean Crear(List<DatosHerramientasUsadasBean> datos);
	MsgBean Modificar(DatosHerramientasUsadasBean datos);
	MsgBean Eliminar(DatosHerramientasUsadasBean datos);
	List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos);
	List<DatosHerramientasUsadasBean> Listar();
}
