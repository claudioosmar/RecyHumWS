/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosCorreoAlt;
import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCorreoAlt;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosCorreoAltImpl implements BODatosCorreoAlt {
	@Autowired
	private DAODatosCorreoAlt daocorreo;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Crear(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public MsgBean Crear(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daocorreo.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Modificar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public MsgBean Modificar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Buscar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public DatosCorreoAltBean Buscar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Listar()
	 */
	@Override
	public List<DatosCorreoAltBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
