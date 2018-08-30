/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosIdiomas {
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO IDIOMAS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosIdiomasBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO IDIOMAS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosIdiomasBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO IDIOMAS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosIdiomasBean datos);
	//REGRESA UNA BUSQUEDA DE LOS DATOS DE APARTADO IDIOMAS
	List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos);
	List<DatosIdiomasBean> Listar();
}
