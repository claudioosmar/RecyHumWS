/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;
import com.vector.Utileria.EnvioMensaje;

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
	public MsgBean Crear(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Actualizar(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public MsgBean Modificar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Eliminar(id);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
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
