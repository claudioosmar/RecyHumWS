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
	public MsgBean Crear(List<DatosIdiomasBean> datos) {
		// TODO Auto-generated method stub
		int resultado=0;
				
		for (int i = 0; i < datos.size(); i++) {
			resultado = daoidiomas.Crear(datos.get(i));
			if(resultado==0) {
				System.out.println("Fallo en la insercion de idioma "+i+1);
			}
		}
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
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
		int respuesta = daoidiomas.Modificar(datos);
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
	 * @see com.vector.BO.BOIdiomas#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daoidiomas.Eliminar(datos);
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
	 * @see com.vector.BO.BOIdiomas#Buscar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		return daoidiomas.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Listar()
	 */
	@Override
	public List<DatosIdiomasBean> Listar() {
		// TODO Auto-generated method stub
		return daoidiomas.Listar();
	}

}
