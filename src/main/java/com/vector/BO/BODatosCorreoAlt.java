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
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE CORREOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosCorreoAltBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE CORREOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosCorreoAltBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE CORREOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosCorreoAltBean datos);
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO DE CORREOALT
	DatosCorreoAltBean Buscar(DatosCorreoAltBean datos);
	//REGRESA UN LISTADO DE LOS DATOS DEL APARTADO DE CORREOALT
	List<DatosCorreoAltBean> Listar(long id);
	/**
	 * @param datos
	 * @return
	 */
	
}
