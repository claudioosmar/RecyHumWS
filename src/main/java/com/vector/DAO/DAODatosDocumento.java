/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosDocumentoBean;

/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
public interface DAODatosDocumento {
	int  Crear(DatosDocumentoBean datos);
	int  Modificar(DatosDocumentoBean datos);
	int  Eliminar(int id);
	DatosDocumentoBean Buscar(DatosDocumentoBean datos);
	List<DatosDocumentoBean> Listar(long id);
}
