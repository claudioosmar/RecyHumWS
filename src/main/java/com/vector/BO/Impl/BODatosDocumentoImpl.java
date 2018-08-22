/**
 * 
 */
package com.vector.BO.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BODatosDocumentos;
import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;
import com.vector.DAO.DAODatosDocumento;
import com.vector.Utileria.EnvioMensaje;

/**
 * @author vectormx
 *
 */
@Service
public class BODatosDocumentoImpl implements BODatosDocumentos {
	@Autowired
	private DAODatosDocumento daodoc;
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Crear(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public MsgBean Crear(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daodoc.Crear(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Modificar(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public MsgBean Modificar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Buscar(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public DatosDocumentoBean Buscar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosDocumentos#Listar()
	 */
	@Override
	public List<DatosDocumentoBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
