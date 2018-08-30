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
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosDocumento {
	//tipo de dato regresado por los beans de docuemntos
	int  Crear(DatosDocumentoBean datos);
	//tipo de dato regresado por los beans de docuemntos
	int  Modificar(DatosDocumentoBean datos);
	//tipo de dato regresado por los beans de docuemntos
	int  Eliminar(DatosDocumentoBean datos);
	//regresa un listado de busqueda de los datos de documentos bean
	List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos);
	List<DatosDocumentoBean> Listar(long id);
}
