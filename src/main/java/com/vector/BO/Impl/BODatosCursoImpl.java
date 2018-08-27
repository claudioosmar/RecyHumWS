/**
 * BODatosCursoImpl.java -- 25/08/2018
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosCurso;
import com.vector.Beans.DatosCursoBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCurso;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author Jair
 *
 */
@Service
public class BODatosCursoImpl implements BODatosCurso {
	@Autowired
	private DAODatosCurso daocurso;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCurso#Crear(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	public MsgBean Crear(List<DatosCursoBean> datos) {
		// TODO Auto-generated method stub
		int resultado=0;
		
		for (int i = 0; i < datos.size(); i++) {
			resultado = daocurso.Crear(datos.get(i));
			if(resultado==0) {
				System.out.println("Fallo en la insercion de curso "+i+1);
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
	 * @see com.vector.BO.BODatosCurso#Modificar(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	public MsgBean Modificar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daocurso.Modificar(datos);
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
	 * @see com.vector.BO.BODatosCurso#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daocurso.Eliminar(datos);
		MsgBean msj = new MsgBean();
		if(respuesta==0) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
	
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCurso#Buscar(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	public List<DatosCursoBean> Buscar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		return daocurso.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCurso#Listar()
	 */
	@Override
	public List<DatosCursoBean> Listar() {
		// TODO Auto-generated method stub
		return daocurso.Listar();
	}

}
