/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosPersonales;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosPersonalesImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosPersonalesImpl extends Log implements BODatosPersonales {
	
	/** The datospersonales. */
	@Autowired
	private DAODatosPersonales datospersonales;
	@Autowired
	private BOPistaAuditora audit;

	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	//Creacion de datos Personales
	public DatosPersonalesBean Crear(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Crear Datos Personales "+datos);
		int respuesta = 0;
		DatosPersonalesBean retorno = new DatosPersonalesBean();
			info("envia respuesta"+respuesta);
			retorno.setIdpersona(datospersonales.Crear(datos));
			respuesta= Integer.parseInt(String.valueOf(retorno.getIdpersona()));
			if (respuesta == 0) {
				error("fallo la insercion ");
				datos.setStatusOp("0");
		}else {
			info("insercion correcta");
			datos.setStatusOp("1");
		}
			audit.GrabarPistaAuditora(datos);		
			return retorno;
			
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	//Modificacion de DatosPersonales
	public MsgBean Modificar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		//Condicional para el envio del mensaje de respuesta
		datos.setAccion("Modificar Datos Personales "+datos);
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar(datos);
		info("entra en la sentencia if");
		//condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
		}
		//Se genera mensaje de modificacion fallida
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
		}
		//Se regresa el mensaje
		audit.GrabarPistaAuditora(datos);
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		//Condicional para el envio del mensaje de respuesta
		datos.setAccion("Eliminar Datos Personales "+datos);
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Eliminar(datos.getIdpersona());
		info("entra en la sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje de eliminacion correcta
		if(resultado == 1) {
			info("mensjae correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensaje de eliminacion fallida
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
		}
		audit.GrabarPistaAuditora(datos);
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public DatosPersonalesBean Buscar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		info("entra en el metodo buscar");
		datos.setAccion("Buscar Datos Personales "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return datospersonales.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> Listar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		info("entra en el metoo listar");
		datos.setAccion("Listar Datos Personales "+datos);
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return datospersonales.Listar();
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar2(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Listar Datos Personales "+datos);
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar2(datos);
		info("entra en sentencia if");
		//condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			info("mensaje correcto: " + resultado);
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
		}
		//Se genera mensaje de modificacion fallida
		else {
			error("mensaje error: "+resultado);
			datos.setStatusOp("0");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		//Se regresa el mensaje
		audit.GrabarPistaAuditora(datos);
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar3(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar3 Datos Personales "+datos);
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar3(datos);
		info("entra en la sentencia if");
		//condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
		}
		//Se genera mensaje de modificacion fallida
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
		}
		//Se regresa el mensaje
		audit.GrabarPistaAuditora(datos);
		return mensaje;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaEstudiosPersona(long id) {
		// TODO Auto-generated method stub
		info("entra en el metodo buscar con id persona "+id);
		return datospersonales.BusquedaEstudiosPersona(id);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaNombreCompleto(String parametro) {
		// TODO Auto-generated method stub
		info("entra en el metodo buscar con id persona "+parametro);
		return datospersonales.BusquedaPersonaNombreCompleto(parametro);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaHerramientasConPersona(long id) {
		// TODO Auto-generated method stub
		info("entra en el metodo buscar con id persona "+id);
		return datospersonales.BusquedaHerramientasConPersona(id);
	}

	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaExpLaboralPersona(long id) {
		// TODO Auto-generated method stub
		info("entra en el metodo buscar con id persona "+id);
		return datospersonales.BusquedaExpLaboralPersona(id);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaIdiomasPersona(long id) {
		// TODO Auto-generated method stub
		info("entra en el metodo buscar con id persona "+id);
		return datospersonales.BusquedaIdiomasPersona(id);
	}
	

}
