/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosHerramientas;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosHerramientas;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosHerramientasImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosHerramientasImpl extends Log implements BODatosHerramientas {
	
	/** The daoherrm. */
	@Autowired
	private DAODatosHerramientas daoherrm;
	@Autowired
	private BOPistaAuditora audit;

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosHerramientasBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Herramienta "+datos);
		int resultado=0;
		//Sentencia for para la validacion del tamaño de los datos del bean
		info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			resultado = daoherrm.Crear(datos.get(i));
			if(resultado==0) {
				error("Fallo en la insercion de herramientas "+i+1);
			}
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		info("entra en sentencia if");
		if(resultado == 0) {
			info("mensaje correcto");
			datos.get(0).setStatusOp("1");
			audit.GrabarPistaAuditora(datos.get(0));
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
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
	public MsgBean Modificar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Herramienta "+datos);
		int respuesta = daoherrm.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
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
	public MsgBean Eliminar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Herramienta "+datos);
		int respuesta=daoherrm.Eliminar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcot");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
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
	public List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Buscar Herramienta "+datos);
		info("entra en metodo buscar ");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daoherrm.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasBean> Listar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Listar Herramienta "+datos);
		info("entra en metodo listar");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daoherrm.Listar();
	}

}
