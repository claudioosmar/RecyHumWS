/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosCertificado;
import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCertificado;
import com.vector.DAO.Impl.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosCertificadoImpl implements BODatosCertificado {
	@Autowired
	private DAODatosCertificado daocertificado;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Crear(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public MsgBean Crear(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daocertificado.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Modificar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public MsgBean Modificar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Buscar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public DatosCertificadoBean Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Listar()
	 */
	@Override
	public List<DatosCertificadoBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
