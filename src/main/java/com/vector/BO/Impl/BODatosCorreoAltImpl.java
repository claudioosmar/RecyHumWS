/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosCorreoAlt;
import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCorreoAlt;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
@Service
public class BODatosCorreoAltImpl implements BODatosCorreoAlt {
	@Autowired
	private DAODatosCorreoAlt daocorreo;
	
	private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Crear(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public MsgBean Crear(List<DatosCorreoAltBean> datos) {
		// TODO Auto-generated method stub
		int respuesta=0;
		for (int i = 0; i < datos.size(); i++) {
			respuesta = daocorreo.Crear(datos.get(i));
			if (respuesta==0) {
				System.out.println("Fallo en la insercion"+i+1);
				break;
			}
			
		}
		MsgBean mensaje = new MsgBean();
		LOGGER.info("Este es la respuesta: "+Integer.valueOf(respuesta).toString());
		
		if(respuesta == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		    return mensaje;
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
		int respuesta = daocorreo.Modificar(datos);
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(String id) {
		// TODO Auto-generated method stub
		int respuesta=daocorreo.Eliminar(id);
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Buscar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public DatosCorreoAltBean Buscar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		return daocorreo.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCorreoAlt#Listar()
	 */
	@Override
	public List<DatosCorreoAltBean> Listar(long id) {
		// TODO Auto-generated method stub
		return daocorreo.Listar(id);
	}

}
