/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;

/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
public interface BODatosDocumentos {
	//MENSAJE DE CREACION DE DATOS EN DOCUMENTOS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosDocumentoBean> datos);
	//MENSAJE DE MODIFICACION DE DATOS EN DOCUMENTOS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosDocumentoBean datos);
	//MENSAJE DE ELIMINACION DE DATOS EN DOCUMENTOS QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosDocumentoBean datos);
	//BUSQUEDA DE DATOS DE DOCUMENTOS
	List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos);
	//LISTADO DE DATOS DE DOCUMENTOS
	List<DatosDocumentoBean> Listar(long id);
}
