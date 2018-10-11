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
import com.vector.Utileria.Log;

import java.util.logging.Logger;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosTelefonoAltImpl extends Log implements BODatosTelefonoAlt {
@Autowired
private DAODatosTelefonoAlt telefone;

private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");
	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Crear(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public MsgBean Crear(List<DatosTelefonoAltBean> datos) {
		// TODO Auto-generated method stub
		int respuesta=0;
	info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			respuesta = telefone.Crear(datos.get(i));
			if(respuesta==0) {
				
				error("Fallo en la insersion"+i+1);
				break;
			}
		}
		
		MsgBean msj = new MsgBean();
		LOGGER.info("Este es la respuesta: " + Integer.valueOf(respuesta).toString());
		info("entra en sentencia if");
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			return msj;
		}else {
			error("mensaje error");
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
		info("entra en sentencia if");
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			error("mensaje error");
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
		info("entra en la sentencia if");
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			error("mensaje error");
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
		info("mensaje correcto");
		return telefone.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOTelefonAlt#Listar()
	 */
	@Override
	public List<DatosTelefonoAltBean> Listar(long id) {
		// TODO Auto-generated method stub
		error("mensaje error");
		return telefone.Listar(id);
	}

}
