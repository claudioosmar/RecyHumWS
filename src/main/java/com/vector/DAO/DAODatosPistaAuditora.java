/**
 * 
 */
package com.vector.DAO;

import java.util.List;


import com.vector.Beans.DatosPistaAuditoraBean;

/**
 * @author vectormx
 *
 */
public interface DAODatosPistaAuditora {
	String agregaracceso(DatosPistaAuditoraBean datos);
	int  Crear(DatosPistaAuditoraBean datos);
	int  Modificar(DatosPistaAuditoraBean datos);
	int  Eliminar(int id);
	DatosPistaAuditoraBean Buscar(DatosPistaAuditoraBean datos);
	List<DatosPistaAuditoraBean> Listar();
}
