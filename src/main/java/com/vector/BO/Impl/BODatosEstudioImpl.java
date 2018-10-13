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


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BODatosEstudioImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar y listar implementados del BO
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class BODatosEstudioImpl extends Log implements BODatosEstudio {
	
	/** The daoestudio. */
	@Autowired
	private DAODatosEstudio daoestudio;


	/** 
	 * {@inheritDoc}
	 */
	@Override

	public DatosEstudioBean Crear(List<DatosEstudioBean> datos) {
		// TODO Auto-generated method stub
		int respuesta = 0;
		DatosEstudioBean retorno = new DatosEstudioBean();
		info("entra en ciclo for");
		for (int i = 0; i < datos.size(); i++) {
			retorno.setIdestudio(daoestudio.Crear(datos.get(i)));
			respuesta= Integer.parseInt(String.valueOf(retorno.getIdestudio()));
			info("envia respuesta: "+respuesta);
			if (respuesta == 0) {
				error("fallo la insercion " + i + 1);
				break;
			}
		}

		return retorno;
	}


	/** 
	 * {@inheritDoc}
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


	/** 
	 * {@inheritDoc}
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


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosEstudioBean> Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		info("entra en metodo buscar");
		return daoestudio.Buscar(datos);
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		info("entra en metodo listar");
		return daoestudio.Listar();
	}

}
