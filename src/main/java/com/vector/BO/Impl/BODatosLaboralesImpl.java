/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosLaborales;
import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosLaborales;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosLaboralesImpl implements BODatosLaborales {
	@Autowired
	private DAODatosLaborales daolabor;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Crear(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public MsgBean Crear(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daolabor.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Modificar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public MsgBean Modificar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Buscar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public DatosLaboralesBean Buscar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Listar()
	 */
	@Override
	public List<DatosLaboralesBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
