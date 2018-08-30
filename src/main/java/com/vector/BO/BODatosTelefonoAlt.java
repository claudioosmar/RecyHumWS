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
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE TELEFONOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosTelefonoAltBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE TELEFONOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosTelefonoAltBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE TELEFONOALT QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(String id);
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO TELEFONOALT
	DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos);
	//REGRESA UN LISTADO DE LOS DATOS DEL APARTADO TELEFONOALT
	List<DatosTelefonoAltBean> Listar(long id);
}
