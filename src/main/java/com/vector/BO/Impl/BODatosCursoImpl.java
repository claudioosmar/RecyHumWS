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
import com.vector.Utileria.Log;

/**
 * @author Jair
 *
 */
@Service
public class BODatosCursoImpl extends Log implements BODatosCurso {
	@Autowired
	private DAODatosCurso daocurso;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCurso#Crear(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	public MsgBean Crear(List<DatosCursoBean> datos) {
		// TODO Auto-generated method stub
		int resultado=0;
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			resultado = daocurso.Crear(datos.get(i));
			if(resultado==0) {
				error("Fallo en la insercion de curso "+i+1);
			}
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
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
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
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
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
	
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
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
		info("entra en metodo buscar");
		return daocurso.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCurso#Listar()
	 */
	@Override
	public List<DatosCursoBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daocurso.Listar();
	}

}
