/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosHerramientas;
import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosHerramientas;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosHerramientasImpl implements BODatosHerramientas {
	@Autowired
	private DAODatosHerramientas daoherrm;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Crear(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public MsgBean Crear(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daoherrm.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Modificar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public MsgBean Modificar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Buscar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public DatosHerramientasBean Buscar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Listar()
	 */
	@Override
	public List<DatosHerramientasBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
