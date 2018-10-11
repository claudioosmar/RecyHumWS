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
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosHerramientasImpl extends Log implements BODatosHerramientas {
	@Autowired
	private DAODatosHerramientas daoherrm;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Crear(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public MsgBean Crear(List<DatosHerramientasBean> datos) {
		// TODO Auto-generated method stub
		int resultado=0;
		//Sentencia for para la validacion del tamaño de los datos del bean
		info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			resultado = daoherrm.Crear(datos.get(i));
			if(resultado==0) {
				error("Fallo en la insercion de herramientas "+i+1);
			}
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		info("entra en sentencia if");
		if(resultado == 0) {
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
	 * @see com.vector.BO.BODatosHerramientas#Modificar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public MsgBean Modificar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoherrm.Modificar(datos);
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
	 * @see com.vector.BO.BODatosHerramientas#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daoherrm.Eliminar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcot");
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
	 * @see com.vector.BO.BODatosHerramientas#Buscar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar ");
		return daoherrm.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientas#Listar()
	 */
	@Override
	public List<DatosHerramientasBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daoherrm.Listar();
	}

}
