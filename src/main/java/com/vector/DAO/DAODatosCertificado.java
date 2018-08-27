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
public interface DAODatosCertificado {
	int  Crear(DatosCertificadoBean datos);
	int  Modificar(DatosCertificadoBean datos);
	int  Eliminar(int id);
	DatosCertificadoBean Buscar(DatosCertificadoBean datos);
	List<DatosCertificadoBean> Listar(int id);
}
