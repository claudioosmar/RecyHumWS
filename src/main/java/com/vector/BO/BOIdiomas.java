/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosIdiomasBean;

/**
 * @author vectormx
 *
 */
public interface BOIdiomas {
	String Crear(DatosIdiomasBean datos);
	String Modificar(DatosIdiomasBean datos);
	String Eliminar(int id);
	DatosIdiomasBean Buscar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Listar();
}
