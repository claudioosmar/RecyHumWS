/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosPersonalesImpl implements BODatosPersonales {
	@Autowired
	private DAODatosPersonales datospersonales;

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Crear(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public DatosPersonalesBean Crear(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		return datospersonales.Crear(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Actualizar(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public DatosPersonalesBean Actualizar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		return datospersonales.Actualizar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Eliminar(int)
	 */
	@Override
	public String Eliminar(int id) {
		// TODO Auto-generated method stub
		return datospersonales.Eliminar(id);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Buscar(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public DatosPersonalesBean Buscar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		return datospersonales.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Listar(java.util.List)
	 */
	@Override
	public List<DatosPersonalesBean> Listar() {
		// TODO Auto-generated method stub
		return datospersonales.Listar();
	}

}
