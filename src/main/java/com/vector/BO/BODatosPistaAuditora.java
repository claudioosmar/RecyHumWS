/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosPistaAuditora {
	
	String agregaraceso(DatosPistaAuditoraBean datos);
	MsgBean Crear(DatosPistaAuditoraBean datos);
	MsgBean Modificar(DatosPistaAuditoraBean datos);
	MsgBean Eliminar(int id);
	DatosPistaAuditoraBean Buscar(DatosPistaAuditoraBean datos);
	List<DatosPistaAuditoraBean> Listar();

}
