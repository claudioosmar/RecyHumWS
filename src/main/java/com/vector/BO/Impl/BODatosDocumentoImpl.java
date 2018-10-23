/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import com.vector.BO.BODatosDocumentos;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosDocumento;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosDocumentoImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosDocumentoImpl extends Log implements BODatosDocumentos {
	
	/** The daodoc. */
	@Autowired
	private DAODatosDocumento daodoc;
	@Autowired
	private BOPistaAuditora audit;
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosDocumentoBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Documento "+datos);
		int respuesta=0;
		info("entra en ciclo for");
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			 respuesta = daodoc.Crear(datos.get(i));
			 if(respuesta==0) {
				 error("fallo la insercion "+i+1);
				 break;
			 }
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		
		LOGGER.info("Este es la respuesta: "+ Integer.valueOf(respuesta).toString());
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.get(0).setStatusOp("1");
			audit.GrabarPistaAuditora(datos.get(0));
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
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
	public MsgBean Modificar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Documento "+datos);
		int respuesta = daodoc.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		LOGGER.info("Este es la respuesta: " + Integer.valueOf(respuesta).toString());
		info("entra en sentencia if");
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
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
	public MsgBean Eliminar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Documento "+datos);
		int respuesta=daodoc.Eliminar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
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
	public List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Buscar Documento "+datos);
		info("entra en metodo buscar");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daodoc.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosDocumentoBean> Listar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Listar Documento "+datos);
		info("entra en metodo listar"+datos.getIdpersona());
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daodoc.Listar(datos.getIdpersona());
	}

}
