/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosPersonalesImpl implements BODatosPersonales {
	@Autowired
	private DAODatosPersonales datospersonales;

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Crear(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	//Creacion de datos Personales
	public DatosPersonalesBean Crear(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		DatosPersonalesBean retorno = new DatosPersonalesBean();
		int respuesta = datospersonales.Crear(datos);
		retorno.setIdpersona(respuesta);
		return retorno;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Actualizar(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	//Modificacion de DatosPersonales
	public MsgBean Modificar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar(datos);
		//condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//Se genera mensaje de modificacion fallida
		else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		//Se regresa el mensaje
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Eliminar(datos.getIdpersona());
		//Condicion para el resultado donde sea igual a 1 mandar mensaje de eliminacion correcta
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensaje de eliminacion fallida
		else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Buscar(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public DatosPersonalesBean Buscar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		return datospersonales.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Listar(java.util.List)
	 */
	@Override
	public List<DatosPersonalesBean> Listar() {
		// TODO Auto-generated method stub
		return datospersonales.Listar();
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Modificar2(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public MsgBean Modificar2(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar2(datos);
		//condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//Se genera mensaje de modificacion fallida
		else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		//Se regresa el mensaje
		return mensaje;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#Modificar3(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public MsgBean Modificar3(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = datospersonales.Modificar3(datos);
		//condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//Se genera mensaje de modificacion fallida
		else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		//Se regresa el mensaje
		return mensaje;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#BusquedaArea()
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaArea(String area) {
		// TODO Auto-generated method stub
		return datospersonales.BusquedaArea(area);
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.BO.BODatosPersonales#BusquedaNombreCompleto(java.lang.String)
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaNombreCompleto(String parametro) {
		// TODO Auto-generated method stub
		return datospersonales.BusquedaPersonaNombreCompleto(parametro);
	}
	

}
