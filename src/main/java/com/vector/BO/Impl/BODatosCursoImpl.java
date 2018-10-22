/**
 * BODatosCursoImpl.java -- 25/08/2018
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosCurso;
import com.vector.Beans.DatosCursoBean;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCurso;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosCursoImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosCursoImpl extends Log implements BODatosCurso {
	
	/** The daocurso. */
	@Autowired
	private DAODatosCurso daocurso;
	@Autowired
	private BOPistaAuditoraImpl audit;

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Crear(List<DatosCursoBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Curso "+datos);
		int resultado=0;
		DatosCursoBean retorno = new DatosCursoBean();
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			retorno.setIdcurso( daocurso.Crear(datos.get(i)));
			resultado= Integer.parseInt(String.valueOf(retorno.getIdcurso()));
			info("insercion correcta --> "+resultado +retorno.getIdcurso() );
			if(resultado==0) {
				error("Fallo en la insercion de curso "+i+1);
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
			audit.GrabarPistaAuditora(datos.get(0));
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
	public MsgBean Modificar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Curso "+datos);
		int respuesta = daocurso.Modificar(datos);
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
	public MsgBean Eliminar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Curso "+datos);
		int respuesta=daocurso.Eliminar(datos);
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
	public List<DatosCursoBean> Buscar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Buscar Curso "+datos);
		info("entra en metodo buscar");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daocurso.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosCursoBean> Listar(DatosPistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Listar Curso "+datos);
		info("entra en metodo listar");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daocurso.Listar();
	}

}
