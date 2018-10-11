/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import com.vector.BO.BODatosDocumentos;
import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosDocumento;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;
/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
@Service
public class BODatosDocumentoImpl extends Log implements BODatosDocumentos {
	@Autowired
	private DAODatosDocumento daodoc;
	
	private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Crear(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public MsgBean Crear(List<DatosDocumentoBean> datos) {
		// TODO Auto-generated method stub
		int respuesta=0;
		info("entra en ciclo for");
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			 respuesta = daodoc.Crear(datos.get(i));
			 if(respuesta==0) {
				 error("fallo la insercion "+i+1);
				 break;
			 }
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		
		LOGGER.info("Este es la respuesta: "+ Integer.valueOf(respuesta).toString());
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Modificar(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public MsgBean Modificar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daodoc.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		LOGGER.info("Este es la respuesta: " + Integer.valueOf(respuesta).toString());
		info("entra en sentencia if");
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daodoc.Eliminar(datos);
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
			error("mensaje de error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Buscar(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		return daodoc.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Listar()
	 */
	@Override
	public List<DatosDocumentoBean> Listar(long id) {
		// TODO Auto-generated method stub
		info("entra en metodo listar"+id);
		return daodoc.Listar(id);
	}

}
