/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.BO.BODatosLogin;
import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosPistaAuditora;
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
	private DAODatosPistaAuditora audit;


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosInicioSesionBean> ListarUsuarios() {
		// TODO Auto-generated method stub
		info("entra en metodo listar usuario");
		return sesion.Listar();
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosFormularioBean> VerificarUsuario(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo verificar usuario");
		DatosPistaAuditoraBean datos1 = new DatosPistaAuditoraBean();
		datos1.setAccion("prueba ");
		datos1.setFormulario("verificar usuario prueba");
		datos1.setIduser(20);
		datos1.setIpequipo("172.24.4.154");
		datos1.setSistema("S.G.R.H");
		datos1.setStatus("1");
		audit.Crear(datos1);
		
		return sesion.VerificarLogin(datos);
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
		}
		//mensaje de respuesta en caso de que la condicional no se cumpla mande mensaje fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
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
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(long id) {
		// TODO Auto-generated method stub
		
		int respuesta=sesion.Delete(id);
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto " + respuesta);
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error - "+ respuesta);
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
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
		return sesion.Buscar(datos);
	}
	
	

}
