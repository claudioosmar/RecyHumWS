/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vector.BO.BODatosIdiomas;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosIdiomas;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosIdiomaImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  18/10/2018 Jair de Jesus Barcenas Gomez - Modificacion correccion de mensajes
 *   
 */
@Service
public class BODatosIdiomaImpl extends Log implements BODatosIdiomas {
	
	/** The daoidiomas. */
	@Autowired
	private DAODatosIdiomas daoidiomas;
	@Autowired
	private BOPistaAuditora audit;

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosIdiomasBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Idioma "+datos);
		int resultado=0;
		//Sentencia for para la validacion del tamaño de los datos del bean		
		info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			info("mensaje correcto");
			resultado = daoidiomas.Crear(datos.get(i));
			if(resultado==0) {
				error("mensaje de error");
				error("Fallo en la insercion de idioma "+i+1);
			}
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.get(0).setStatusOp("1");
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.get(0).setStatusOp("0");
		}
		audit.GrabarPistaAuditora(datos.get(0));
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Idioma "+datos);
		int respuesta = daoidiomas.Modificar(datos);
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
	public MsgBean Eliminar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Idioma "+datos);
		int respuesta=daoidiomas.Eliminar(datos);
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
	public List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Buscar Idioma "+datos);
		info("entra en metodo buscar ");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daoidiomas.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosIdiomasBean> Listar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Listar Idioma "+datos);
		info("entra en metodo listar");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daoidiomas.Listar();
	}

}
