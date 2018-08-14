/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import com.vector.BO.LoginBO;
import com.vector.Beans.BeanInicioSesion;
import com.vector.Beans.DatosPersonalesBean;
import com.vector.DAO.SesionDAO;

/**
 * @author vectormx
 *
 */
public class LoginBOImpl implements LoginBO<BeanInicioSesion> {
	
	private SesionDAO<BeanInicioSesion> sesion;

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#ListarUsuarios()
	 */
	@Override
	public List<BeanInicioSesion> ListarUsuarios() {
		// TODO Auto-generated method stub
		return sesion.Listar();
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#VerificarUsuario(java.lang.Object)
	 */
	@Override
	public String VerificarUsuario(BeanInicioSesion datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.LoginBO#CreateUser(java.lang.Object)
	 */
	@Override
	public BeanInicioSesion CreateUser(BeanInicioSesion datos) {
		// TODO Auto-generated method stub
		return null;
	}



}
