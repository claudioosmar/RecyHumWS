/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosLaborales;
import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosLaborales;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosLaboralesImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosLaboralesImpl extends Log implements BODatosLaborales {
	
	/** The daolabor. */
	@Autowired
	private DAODatosLaborales daolabor;
	@Autowired
	private BOPistaAuditora audit;
	
	/** 
	 * {@inheritDoc}
	 */
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Crear(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public DatosLaboralesBean Crear(List<DatosLaboralesBean> datos) {
		// TODO Auto-generated method stub
		datos.get(0).setAccion("Crear Laborales "+datos);
		int respuesta = 0;
		DatosLaboralesBean retorno = new DatosLaboralesBean();
		MsgBean msj= new MsgBean();
		info("entra en ciclo for");
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			retorno.setIdexplaborl(daolabor.Crear(datos.get(i)));
			respuesta= Integer.parseInt(String.valueOf(retorno.getIdexplaborl()));
			if (respuesta == 0) {
				error("fallo la insercion " + i + 1);
				msj.setMsjAccion(new EnvioMensaje().getFallo());
				retorno.setMsj(msj);
				datos.get(0).setStatusOp("0");
				audit.GrabarPistaAuditora(datos.get(0));
				break;
			}		
		}
		
		msj.setMsjAccion(new EnvioMensaje().getCorrecto());
		retorno.setMsj(msj);
		datos.get(0).setStatusOp("1");
		audit.GrabarPistaAuditora(datos.get(0));
		return retorno;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Modificar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Modificar Laboral "+datos);
		int respuesta = daolabor.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		info("entra en sentencia if");
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta==1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
			audit.GrabarPistaAuditora(datos);
			return mensaje;
		}
		
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public MsgBean Eliminar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Eliminar Laboral "+datos);
		int respuesta = daolabor.Eliminar(datos.getIdexplaborl());
		MsgBean mensaje = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			datos.setStatusOp("1");
			audit.GrabarPistaAuditora(datos);
			return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			datos.setStatusOp("0");
			audit.GrabarPistaAuditora(datos);
			return mensaje;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Buscar Laboral "+datos);
		info("entra en metodo buscar ");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return daolabor.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosLaboralesBean> Listar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		datos.setAccion("Listar Laboral "+datos);
		info("entra en metodo listar");
		datos.setStatusOp("1");
		audit.GrabarPistaAuditora(datos);
		return null;
	}

}
