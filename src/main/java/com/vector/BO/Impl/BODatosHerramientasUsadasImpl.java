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
		
		for (int i = 0; i < datos.size(); i++) {
			resultado = daoherramientas.Crear(datos.get(i));
			if(resultado==0) {
				System.out.println("Fallo en la insercion de herramientas usadas "+i+1);
			}
		}
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
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
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
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
		MsgBean msj = new MsgBean();
		if(respuesta==1) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
			
			return msj;
		}else {
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
