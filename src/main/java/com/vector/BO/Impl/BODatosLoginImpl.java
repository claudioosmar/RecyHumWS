/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.BO.BODatosLogin;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosSesion;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosLoginImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosLoginImpl extends Log implements BODatosLogin {

	/** The sesion. */
	@Autowired
	private DAODatosSesion sesion;
	@Autowired
	private BOPistaAuditora audit;


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosInicioSesionBean> ListarUsuarios(DatosPistaAuditoraBean datos) {
		
		// TODO Auto-generated method stub
		info("entra en metodo listar usuario");
		datos.setAccion("Listar Todos los usuarios");
		datos.setStatusOp("1");
//		datos.setIduserp(datos.get);
		audit.GrabarPistaAuditora(datos);
		return sesion.Listar();
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosFormularioBean> VerificarUsuario(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo verificar usuario");
		List<DatosFormularioBean> respuesta = sesion.VerificarLogin(datos);
		if (respuesta.size()==1) {
			datos.setIduserp(respuesta.get(0).getIdpersona());
			datos.setStatusOp("1");
		}else {
			datos.setStatusOp("0");
			datos.setIduserp(0);
		}
		
		audit.GrabarPistaAuditora(datos);
		
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public MsgBean CreateUser(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = sesion.Create(datos);
		info("entra en sentencia if");
		//condicional para el inicio de sesion que genera el mensaje correcto
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setAccion("El ID de persona "+datos.getIdpersona()+"creo el usuario "+datos.getUsuario());
			datos.setStatusOp("1");
			datos.setIduserp(datos.getIdpersona());
		}
		//mensaje de respuesta en caso de que la condicional no se cumpla mande mensaje fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setAccion("El ID de persona "+datos.getIdpersona()+"creo el usuario "+datos.getUsuario());
			datos.setStatusOp("0");
			datos.setIduserp(datos.getIdpersona());
		}
		audit.GrabarPistaAuditora(datos);
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public MsgBean Modificar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = sesion.Modificar(datos);
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setAccion("El ID de persona "+datos.getIdpersona()+"modifico el usuario "+datos.getUsuario());
			datos.setStatusOp("1");
			datos.setIduserp(datos.getIdpersona());
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setAccion("El ID de persona "+datos.getIdpersona()+"modifico el usuario "+datos.getUsuario());
			datos.setStatusOp("0");
			datos.setIduserp(datos.getIdpersona());
		}
		audit.GrabarPistaAuditora(datos);
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		
		int respuesta=sesion.Delete(datos.getIduserp());
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto " + respuesta);
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setAccion("El ID de persona "+datos.getIdpersona()+"elimino el usuario "+datos.getUsuario());
			datos.setStatusOp("1");
			datos.setIduserp(datos.getIdpersona());
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error - "+ respuesta);
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setAccion("El ID de persona "+datos.getIdpersona()+"elimino el usuario "+datos.getUsuario());
			datos.setStatusOp("0");
			datos.setIduserp(datos.getIdpersona());
			return msj;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public DatosInicioSesionBean Buscar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		info("entra al metodo buscar");
		datos.setAccion("Buscando datos");
		datos.setStatusOp("1");
		datos.setIduserp(datos.getIdpersona());
		audit.GrabarPistaAuditora(datos);
		return sesion.Buscar(datos);
	}
	
	

}
