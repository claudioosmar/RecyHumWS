/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosHerramientasUsadas;
import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosHerramientasUsadas;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosHerramientasUsadasImpl extends Log implements BODatosHerramientasUsadas {
	@Autowired
	private DAODatosHerramientasUsadas daoherramientas;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BODatosHerramientasUsadas#Crear(java.util.List)
	 */
	@Override
	public MsgBean Crear(List<DatosHerramientasUsadasBean> datos) {
		// TODO Auto-generated method stub
		int resultado = 0;
		info("entra en ciclo for");
		// Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			resultado = daoherramientas.Crear(datos.get(i));
			if (resultado == 0) {
				error("Fallo en la insercion de herramientas usadas " + i + 1);
			}
		}
		// Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		info("entra en sentencia if");
		// Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if (resultado == 0) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		// mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BODatosHerramientasUsadas#Modificar(com.vector.Beans.
	 * DatosHerramientasUsadasBean)
	 */
	@Override
	public MsgBean Modificar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoherramientas.Modificar(datos);
		// Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		// Condicion que genera mensaje de modificacion exitosa
		if (respuesta == 1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());

			return msj;
		}
		// mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());

			return msj;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BODatosHerramientasUsadas#Eliminar(com.vector.Beans.
	 * DatosHerramientasUsadasBean)
	 */
	@Override
	public MsgBean Eliminar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoherramientas.Eliminar(datos);
		// Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		// Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if (respuesta == 1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());

			return msj;
		}
		// mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());

			return msj;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BODatosHerramientasUsadas#Buscar(com.vector.Beans.
	 * DatosHerramientasUsadasBean)
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		return daoherramientas.Buscar(datos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BODatosHerramientasUsadas#Listar(long)
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daoherramientas.Listar();
	}

}
