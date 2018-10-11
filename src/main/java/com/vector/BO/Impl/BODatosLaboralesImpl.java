/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosLaborales;
import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosLaborales;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosLaboralesImpl extends Log implements BODatosLaborales {
	@Autowired
	private DAODatosLaborales daolabor;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Crear(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public DatosLaboralesBean Crear(List<DatosLaboralesBean> datos) {
		// TODO Auto-generated method stub
		DatosLaboralesBean retorno = new DatosLaboralesBean();
		info("entra en ciclo for");
		//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			info("envia informacio");
			retorno.setIdexplaborl(daolabor.Crear(datos.get(i))); 
		}
		
		return retorno;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Modificar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public MsgBean Modificar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daolabor.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		info("entra en sentencia if");
		//Condicion que genera mensaje de modificacion exitosa
		if(respuesta==1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			return mensaje;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		int respuesta = daolabor.Eliminar(id);
		MsgBean mensaje = new MsgBean();
		info("entra en sentencia if");
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(respuesta==1) {
			info("mensaje correcto");
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			return mensaje;
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			error("mensaje error");
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
			return mensaje;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Buscar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar ");
		return daolabor.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosLaborales#Listar()
	 */
	@Override
	public List<DatosLaboralesBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return null;
	}

}
