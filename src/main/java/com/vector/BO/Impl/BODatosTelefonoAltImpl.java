/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosTelefonoAlt;
import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosTelefonoAlt;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.comandoSQL;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosTelefonoAltImpl implements BODatosTelefonoAlt {
@Autowired
private DAODatosTelefonoAlt telefone;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Crear(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public MsgBean Crear(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		int respuesta = telefone.Crear(datos);
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Modificar(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public MsgBean Modificar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		int respuesta = telefone.Modificar(datos);
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(String id) {
		// TODO Auto-generated method stub
		int respuesta=telefone.Eliminar(id);
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Buscar(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		return telefone.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Listar()
	 */
	@Override
	public List<DatosTelefonoAltBean> Listar(long id) {
		// TODO Auto-generated method stub
		return telefone.Listar(id);
	}

}
