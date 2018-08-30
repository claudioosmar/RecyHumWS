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

/**
 * @author vectormx
 *
 */
@Service
public class BODatosHerramientasUsadasImpl implements BODatosHerramientasUsadas {
	@Autowired
	private DAODatosHerramientasUsadas daoherramientas;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientasUsadas#Crear(java.util.List)
	 */
	@Override
	public MsgBean Crear(List<DatosHerramientasUsadasBean> datos) {
		// TODO Auto-generated method stub
int resultado=0;
//Sentencia for para la validacion del tamaño de los datos del bean
		for (int i = 0; i < datos.size(); i++) {
			resultado = daoherramientas.Crear(datos.get(i));
			if(resultado==0) {
				System.out.println("Fallo en la insercion de herramientas usadas "+i+1);
			}
		}
		//Condicional para el envio del mensaje de respuesta
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		//Condicion para el resultado donde sea igual a 1 mandar mensaje correcto
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}
		//mensaje en respuesta si la condicional no se cumple mandar mensale de fallo
		else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientasUsadas#Modificar(com.vector.Beans.DatosHerramientasUsadasBean)
	 */
	@Override
	public MsgBean Modificar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoherramientas.Modificar(datos);
		//Condicional para el envio del mensaje de respuesta
		MsgBean msj = new MsgBean();
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
	 * @see com.vector.BO.BODatosHerramientasUsadas#Eliminar(com.vector.Beans.DatosHerramientasUsadasBean)
	 */
	@Override
	public MsgBean Eliminar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daoherramientas.Eliminar(datos);
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
	 * @see com.vector.BO.BODatosHerramientasUsadas#Buscar(com.vector.Beans.DatosHerramientasUsadasBean)
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		return daoherramientas.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosHerramientasUsadas#Listar(long)
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Listar() {
		// TODO Auto-generated method stub
		return daoherramientas.Listar();
	}

}
