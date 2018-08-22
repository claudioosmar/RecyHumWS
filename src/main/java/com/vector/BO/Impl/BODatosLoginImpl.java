/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.BO.BODatosLogin;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosSesion;
import com.vector.DAO.Impl.EnvioMensaje;

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
	public String VerificarUsuario(DatosInicioSesionBean datos) {
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



}
