/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vector.BO.BODatosIdiomas;
import com.vector.Beans.DatosIdiomasBean;
import com.vector.DAO.DAODatosIdiomas;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosIdiomaImpl implements BODatosIdiomas {
	@Autowired
	private DAODatosIdiomas idiomas;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Crear(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public String Crear(DatosIdiomasBean datos) {
		int respuesta = idiomas.Crear(datos);
		// TODO Auto-generated method stub
		if (respuesta == 1) {
			return "se agrego correctamente";
		}else {
		return "fallo al ingresar";
	}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Modificar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public String Modificar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = idiomas.Modificar(datos);
		// TODO Auto-generated method stub
		if (respuesta == 1) {
			return "se agrego correctamente";
		}else {
		return "fallo al ingresar";
	}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Eliminar(int)
	 */
	@Override
	public String Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Buscar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public DatosIdiomasBean Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Listar()
	 */
	@Override
	public List<DatosIdiomasBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
