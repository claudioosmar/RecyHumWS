/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vector.BO.BODatosTelefonoAlt;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosTelefonoAlt;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

import java.util.logging.Logger;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosTelefonoAltImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosTelefonoAltImpl extends Log implements BODatosTelefonoAlt {

/** The telefone. */
@Autowired
private DAODatosTelefonoAlt telefone;
@Autowired
private BOPistaAuditora audit;

/** The Constant LOGGER. */
private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosTelefonoAltBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Telefono Alt "+datos);
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
			datos.get(0).setStatusOp("1");
			audit.GrabarPistaAuditora(datos.get(0));
			return msj;
		}else {
			error("mensaje error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			datos.get(0).setStatusOp("0");
			audit.GrabarPistaAuditora(datos.get(0));
			return msj;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Telefono Alt "+datos);
		int respuesta = telefone.Modificar(datos);
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}else {
			error("mensaje error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Telefono Alt "+datos);
		int respuesta=telefone.Eliminar(datos.getTelefonoNw());
		MsgBean msj = new MsgBean();
		info("entra en la sentencia if");
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}else {
			error("mensaje error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		info("mensaje correcto");
		datos.setAccion("Buscar Telefono Alt "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return telefone.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosTelefonoAltBean> Listar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		error("mensaje error");
		datos.setAccion("Listar Telefono Alt "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return telefone.Listar(datos.getIdpersona());
	}

}
