/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosEstudioBean;

/**
 * @author vectormx
 *
 */
public interface BODatosEstudio {
	
	String Crear(DatosEstudioBean datos);
	String Modificar(DatosEstudioBean datos);
	String Eliminar(int id);
	DatosEstudioBean Buscar(DatosEstudioBean datos);
	List<DatosEstudioBean> Listar();

}
