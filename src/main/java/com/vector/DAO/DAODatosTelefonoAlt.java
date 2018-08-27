/**
 * 
 */
package com.vector.DAO;

import java.util.List;

import com.vector.Beans.DatosTelefonoAltBean;



/**
 * @author vectormx
 *
 */
public interface DAODatosTelefonoAlt {
	int  Crear(DatosTelefonoAltBean datos);
	int  Modificar(DatosTelefonoAltBean datos);
	int  Eliminar(String id);
	DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos);
	List<DatosTelefonoAltBean> Listar(long id);
}
