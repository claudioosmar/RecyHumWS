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
	//CREACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE DATOSPERSONALESBEAN
	DatosPersonalesBean Crear(DatosPersonalesBean datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosPersonalesBean datos);
	//MENSAJE DE ELINACION DE LOS DATOS DEL APARTADO DE DATOS PERSONALES QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar (DatosPersonalesBean datos);
	//BUSQUEDA DE DATOS DEL APARTADO DE DATOS PERSONALES
	DatosPersonalesBean Buscar(DatosPersonalesBean datos);
	//LISTADO DE DATOS DEL APARTADI DE DATOS PERSONALES
	List<DatosPersonalesBean> Listar ();

}
