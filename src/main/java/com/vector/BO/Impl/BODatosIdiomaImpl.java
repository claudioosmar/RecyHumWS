/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vector.BO.BODatosIdiomas;
import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosIdiomas;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosIdiomaImpl extends Log implements BODatosIdiomas {
	@Autowired
	private DAODatosIdiomas daoidiomas;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Crear(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public MsgBean Crear(List<DatosIdiomasBean> datos) {
		// TODO Auto-generated method stub
		int resultado=0;
		//Sentencia for para la validacion del tamaño de los datos del bean		
		info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			resultado = daoidiomas.Crear(datos.get(i));
			if(resultado==0) {
				error("Fallo en la insercion de idioma "+i+1);
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
	 * @see com.vector.BO.BOIdiomas#Modificar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public MsgBean Modificar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoidiomas.Modificar(datos);
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
	 * @see com.vector.BO.BOIdiomas#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daoidiomas.Eliminar(datos);
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
	 * @see com.vector.BO.BOIdiomas#Buscar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar ");
		return daoidiomas.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOIdiomas#Listar()
	 */
	@Override
	public List<DatosIdiomasBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daoidiomas.Listar();
	}

}
