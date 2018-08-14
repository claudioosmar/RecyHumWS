/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.LoginBO;
import com.vector.Beans.BeanInicioSesion;
import com.vector.DAO.SesionDAO;

/**
 * @author vectormx
 *
 */
@Service
public class LoginBOImpl implements LoginBO {
	@Autowired
	private SesionDAO sesion;

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
