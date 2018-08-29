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
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosSesion;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosLoginImpl implements BODatosLogin {

	@Autowired
	private DAODatosSesion sesion;

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#ListarUsuarios()
	 */
	@Override
	public List<DatosInicioSesionBean> ListarUsuarios() {
		// TODO Auto-generated method stub
		return sesion.Listar();
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#VerificarUsuario(java.lang.Object)
	 */
	@Override
	public List<DatosFormularioBean> VerificarUsuario(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		return sesion.VerificarLogin(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#CreateUser(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public MsgBean CreateUser(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = sesion.Create(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLogin#Modificar(com.vector.Beans.DatosInicioSesionBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public MsgBean Modificar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = sesion.Modificar(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.BO.BODatosLogin#Eliminat(com.vector.Beans.DatosInicioSesionBean)
	 */
	@Override
	public MsgBean Eliminar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		int respuesta=sesion.Delete(datos);
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.BO.BODatosLogin#Buscar(com.vector.Beans.DatosInicioSesionBean)
	 */
	@Override
	public DatosInicioSesionBean Buscar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		return sesion.Buscar(datos);
	}

}
