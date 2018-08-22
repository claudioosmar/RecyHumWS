/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosDocumentoBean;



/**
 * @author vectormx
 *
 */
public interface DAODatosDocumento {
	int  Crear(DatosDocumentoBean datos);
	int  Modificar(DatosDocumentoBean datos);
	int  Eliminar(int id);
	DatosDocumentoBean Buscar(DatosDocumentoBean datos);
	List<DatosDocumentoBean> Listar();
}
