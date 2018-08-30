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

/**
 * @author vectormx
 *
 */
@Service
public class BODatosEstudioImpl implements BODatosEstudio {
	@Autowired
	private DAODatosEstudio daoestudio;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Crear(com.vector.Beans.DatosEstudioBean)
	 */
	@Override

	public DatosEstudioBean Crear(List<DatosEstudioBean> datos) {
		// TODO Auto-generated method stub
		DatosEstudioBean retorno = new DatosEstudioBean();
		for (int i = 0; i < datos.size(); i++) {
			 retorno.setIdestudio(daoestudio.Crear(datos.get(i)));	
		}
		
		return retorno;
	}
	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public MsgBean Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		int respuesta = daoestudio.Modificar(datos);
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
	 * @see com.vector.BO.BOEstudios#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		int respuesta=daoestudio.Eliminar(datos);
		MsgBean msj = new MsgBean();
		if(respuesta==0) {
			msj.setMsjAccion(new EnvioMensaje().getCorrecto());
	
			return msj;
		}else {
			msj.setMsjAccion(new EnvioMensaje().getFallo());
			
			return msj;
		}
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Buscar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public List<DatosEstudioBean> Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		return daoestudio.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BOEstudios#Listar()
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		return daoestudio.Listar();
	}

}
