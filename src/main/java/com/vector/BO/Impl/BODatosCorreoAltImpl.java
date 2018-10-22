/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosCorreoAlt;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCorreoAlt;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosCorreoAltImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosCorreoAltImpl extends Log implements BODatosCorreoAlt {
	
	/** The daocorreo. */
	@Autowired
	private DAODatosCorreoAlt daocorreo;
	@Autowired
	private BOPistaAuditora audit;
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosCorreoAltBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Correo "+datos);
		int respuesta=0;
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("regresa respuesta");
			respuesta = daocorreo.Crear(datos.get(i));
			if (respuesta==0) {
				error("Fallo en la insercion"+i+1);
				break;
			}
			
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		LOGGER.info("Este es la respuesta: "+Integer.valueOf(respuesta).toString());
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		info("entra en sentencia if");
		if(respuesta == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.get(0).setStatusOp("1");
			audit.GrabarPistaAuditora(datos.get(0));
		    return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.get(0).setStatusOp("0");
			audit.GrabarPistaAuditora(datos.get(0));
		}
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Correo "+datos);
		int respuesta = daocorreo.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		info("entra en sentencia if");
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
			audit.GrabarPistaAuditora(datos);
			return mensaje;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Correo "+datos);
		int respuesta=daocorreo.Eliminar(datos);
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
	public DatosCorreoAltBean Buscar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		datos.setAccion("Buscar Correo "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daocorreo.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosCorreoAltBean> Listar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo listar"+datos.getIdpersona());
		datos.setAccion("Listar Correo "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daocorreo.Listar(datos.getIdpersona());
	}

}
