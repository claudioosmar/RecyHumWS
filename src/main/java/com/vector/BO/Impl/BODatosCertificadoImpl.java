/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vector.BO.BODatosCertificado;
import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosCertificado;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosCertificadoImpl extends Log implements BODatosCertificado {
	@Autowired
	private DAODatosCertificado daocertificado;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Crear(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public MsgBean Crear(List<DatosCertificadoBean> datos) {
		// TODO Auto-generated method stub
		int respuesta=0;
		info("entra en ciclo for");
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta");
			respuesta = daocertificado.Crear(datos.get(i));
			if (respuesta==0) {
				error("Fallo en la insercion"+i+1);
		
			}
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		return mensaje;
	}
}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Modificar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public MsgBean Modificar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daocertificado.Modificar(datos);
		info("entra en metodo if mensaje");
		//Condicion que genera mensaje de modificacion exitosa
		if(resultado == 1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje de error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daocertificado.Eliminar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
		info("entra en metodo if mensaje");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Buscar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		return daocertificado.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Listar()
	 */
	@Override
	public List<DatosCertificadoBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daocertificado.Listar();
	}

}
