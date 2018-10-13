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


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosHerramientasUsadasImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosHerramientasUsadasImpl extends Log implements BODatosHerramientasUsadas {
	
	/** The daoherramientas. */
	@Autowired
	private DAODatosHerramientasUsadas daoherramientas;


	/** 
	 * {@inheritDoc}
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


	/** 
	 * {@inheritDoc}
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


	/** 
	 * {@inheritDoc}
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


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		return daoherramientas.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daoherramientas.Listar();
	}

}
