/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosEstudio;
import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosEstudio;
import com.vector.Utileria.EnvioMensaje;
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosEstudioImpl extends Log implements BODatosEstudio {
	@Autowired
	private DAODatosEstudio daoestudio;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BOEstudios#Crear(com.vector.Beans.DatosEstudioBean)
	 */
	@Override

	public DatosEstudioBean Crear(List<DatosEstudioBean> datos) {
		// TODO Auto-generated method stub
		int respuesta = 0;
		DatosEstudioBean retorno = new DatosEstudioBean();
		info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			info("envia respuesta: "+respuesta);
			retorno.setIdestudio(daoestudio.Crear(datos.get(i)));
			respuesta= Integer.parseInt(String.valueOf(retorno.getIdestudio()));
			if (respuesta == 0) {
				error("fallo la insercion " + i + 1);
				break;
			}
		}

		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BOEstudios#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public MsgBean Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoestudio.Modificar(datos);
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		if (respuesta == 1) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());

			return msj;
		} else {
			error("mensaje de error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());

			return msj;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BOEstudios#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoestudio.Eliminar(datos);
		MsgBean msj = new MsgBean();
		info("entra en sentencia if");
		if (respuesta == 0) {
			info("mensaje correcto");
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());

			return msj;
		} else {
			error("mensaje de error");
			msj.setMsjAccion(new EnvioMensaje().getFallo());

			return msj;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BOEstudios#Buscar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public List<DatosEstudioBean> Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		return daoestudio.Buscar(datos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.BO.BOEstudios#Listar()
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daoestudio.Listar();
	}

}
