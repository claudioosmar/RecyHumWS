/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosCertificadoBean;


/**
 * @author vectormx
 *
 */
//interfaz de los tipos de datos de entrada de los DAO
public interface DAODatosCertificado {
	//tipo de dato regresado por los beans de certificado
	int  Crear(DatosCertificadoBean datos);
	//tipo de dato regresado por los beans de certificado
	int  Modificar(DatosCertificadoBean datos);
	//tipo de dato regresado por los beans de certificado
	int  Eliminar(DatosCertificadoBean datos);
	//regresa un listado de busqueda de los datos de certificado
	List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos);
	List<DatosCertificadoBean> Listar();
}
