/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vector.BO.BODatosCertificado;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCertificado;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosCertificadoImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosCertificadoImpl extends Log implements BODatosCertificado {
	
	/** The daocertificado. */
	@Autowired
	private DAODatosCertificado daocertificado;
	@Autowired
	private BOPistaAuditora audit;
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosCertificadoBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Certificado "+datos);
		int respuesta=0;
		info("entra en ciclo for");
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			respuesta = daocertificado.Crear(datos.get(i));
			if (respuesta==0) {
				error("Fallo en la insercion"+i+1);
				datos.get(0).setStatusOp("0");
				audit.GrabarPistaAuditora(datos.get(0));	
			}
		
		}
		datos.get(0).setStatusOp("1");
		audit.GrabarPistaAuditora(datos.get(0));
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
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
		return mensaje;
	}
}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar(DatosCertificadoBean datos) {
		datos.setAccion("Modificar Certificado "+datos);
		// TODO Auto-generated method stub
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daocertificado.Modificar(datos);
		info("entra en metodo if mensaje");
		//Condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
			audit.GrabarPistaAuditora(datos);
		}
		return mensaje;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(DatosCertificadoBean datos) {
		datos.setAccion("Eliminar Certificado "+datos);
		// TODO Auto-generated method stub
		int respuesta=daocertificado.Eliminar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en metodo if mensaje");
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
			error("mensaje correcto");
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
	public List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		datos.setAccion("Buscar Certificado "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daocertificado.Buscar(datos);
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosCertificadoBean> Listar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		datos.setAccion("Listar Certificado "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daocertificado.Listar();
	}

}
