/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosEstudio;
import com.vector.Beans.DatosEstudioBean;
import com.vector.DAO.DAODatosEstudio;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosEstudioImpl implements BODatosEstudio {
	@Autowired
	private DAODatosEstudio daoestudio;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Crear(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public String Crear(DatosEstudioBean datos) {
		int respuesta = daoestudio.Crear(datos);
		// TODO Auto-generated method stub
		if (respuesta == 1) {
			return "se agrego correctamente";
		}else {
		return "fallo al ingresar";
	}
	}
	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public String Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		return daoestudio.Modificar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Eliminar(int)
	 */
	@Override
	public String Eliminar(int id) {
		// TODO Auto-generated method stub
		return daoestudio.Eliminar(id);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Buscar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public DatosEstudioBean Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		return daoestudio.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Listar()
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		return daoestudio.Listar();
	}

}
