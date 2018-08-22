/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosDocumentos {
	MsgBean Crear(DatosDocumentoBean datos);
	MsgBean Modificar(DatosDocumentoBean datos);
	MsgBean Eliminar(int id);
	DatosDocumentoBean Buscar(DatosDocumentoBean datos);
	List<DatosDocumentoBean> Listar();
}
