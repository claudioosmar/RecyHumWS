/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vector.BO.BODatosIdiomas;
import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosIdiomas;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosIdiomaImpl implements BODatosIdiomas {
	@Autowired
	private DAODatosIdiomas daoidiomas;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Crear(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public MsgBean Crear(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daoidiomas.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Modificar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public MsgBean Modificar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daoidiomas.Modificar(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Buscar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public DatosIdiomasBean Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Listar()
	 */
	@Override
	public List<DatosIdiomasBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
