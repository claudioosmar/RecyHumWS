/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosHerramientas;
import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosHerramientas;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosHerramientasImpl implements BODatosHerramientas {
	@Autowired
	private DAODatosHerramientas daoherrm;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Crear(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public MsgBean Crear(List<DatosHerramientasBean> datos) {
		// TODO Auto-generated method stub
		int resultado=0;
		
		for (int i = 0; i < datos.size(); i++) {
			resultado = daoherrm.Crear(datos.get(i));
			if(resultado==0) {
				System.out.println("Fallo en la insercion de herramientas "+i+1);
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
	 * @see com.vector.BO.BODatosHerramientas#Modificar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public MsgBean Modificar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoherrm.Modificar(datos);
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
	 * @see com.vector.BO.BODatosHerramientas#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daoherrm.Eliminar(datos);
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
	 * @see com.vector.BO.BODatosHerramientas#Buscar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		return daoherrm.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Listar()
	 */
	@Override
	public List<DatosHerramientasBean> Listar() {
		// TODO Auto-generated method stub
		return daoherrm.Listar();
	}

}
