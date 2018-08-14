/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BOLogin;
import com.vector.Beans.InicioSesionBean;
import com.vector.DAO.DAOSesion;

/**
 * @author vectormx
 *
 */
@Service
public class BOLoginImpl implements BOLogin {
	@Autowired
	private DAOSesion sesion;

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#ListarUsuarios()
	 */
	@Override
	public List<InicioSesionBean> ListarUsuarios() {
		// TODO Auto-generated method stub
		return sesion.Listar();
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#VerificarUsuario(java.lang.Object)
	 */
	@Override
	public String VerificarUsuario(InicioSesionBean datos) {
		// TODO Auto-generated method stub
		return sesion.VerificarLogin(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#CreateUser(java.lang.Object)
	 */
	@Override
	public InicioSesionBean CreateUser(InicioSesionBean datos) {
		// TODO Auto-generated method stub
		return null;
	}



}
