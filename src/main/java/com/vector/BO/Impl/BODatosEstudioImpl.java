/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosEstudio;
import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosEstudio;
import com.vector.DAO.Impl.EnvioMensaje;

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

	public MsgBean Crear(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daoestudio.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}
	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public MsgBean Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daoestudio.Modificar(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daoestudio.Eliminar(id);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
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
