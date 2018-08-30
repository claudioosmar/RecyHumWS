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
/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
@Service
public class BODatosDocumentoImpl implements BODatosDocumentos {
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
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			 respuesta = daodoc.Crear(datos.get(i));
			 if(respuesta==0) {
				 System.out.println("fallo la insercion "+i+1);
				 break;
			 }
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		
		LOGGER.info("Este es la respuesta: "+ Integer.valueOf(respuesta).toString());;
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
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
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
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
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
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
		return daodoc.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Listar()
	 */
	@Override
	public List<DatosDocumentoBean> Listar(long id) {
		// TODO Auto-generated method stub
		return daodoc.Listar(id);
	}

}
