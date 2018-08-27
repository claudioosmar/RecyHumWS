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
	MsgBean Crear(List<DatosDocumentoBean> datos);
	MsgBean Modificar(DatosDocumentoBean datos);
	MsgBean Eliminar(int id);
	DatosDocumentoBean Buscar(DatosDocumentoBean datos);
	List<DatosDocumentoBean> Listar(long id);
}
