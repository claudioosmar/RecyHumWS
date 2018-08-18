/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

/**
 * @author vectormx
 *
 */
public interface BODatosPersonales {
	
	DatosPersonalesBean Crear(DatosPersonalesBean datos);
	DatosPersonalesBean Actualizar(DatosPersonalesBean datos);
	String Eliminar (int id);
	DatosPersonalesBean Buscar(DatosPersonalesBean datos);
	List<DatosPersonalesBean> Listar ();

}
