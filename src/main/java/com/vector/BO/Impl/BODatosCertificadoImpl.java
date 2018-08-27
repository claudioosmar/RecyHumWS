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



/**
 * @author vectormx
 *
 */
@Service
public class BODatosCertificadoImpl implements BODatosCertificado {
	@Autowired
	private DAODatosCertificado daocertificado;
	
	
	
	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Crear(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public MsgBean Crear(List<DatosCertificadoBean> datos) {
		// TODO Auto-generated method stub
		int respuesta=0;
		for (int i = 0; i < datos.size(); i++) {
			respuesta = daocertificado.Crear(datos.get(i));
			if (respuesta==0) {
				System.out.println("Fallo en la insercion"+i+1);
		
			}
		}

		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		if(respuesta == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
			return mensaje;
		}else {
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
		MsgBean mensaje = new MsgBean();
		mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		int resultado = daocertificado.Modificar(datos);
		if(resultado == 1) {
			mensaje.setMsjAccion(new EnvioMensaje().getCorrecto());
		}else {
			mensaje.setMsjAccion(new EnvioMensaje().getFallo());
		}
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Eliminar(int)
	 */
	@Override
	public MsgBean Eliminar(int id) {
		// TODO Auto-generated method stub
		int respuesta=daocertificado.Eliminar(id);
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
	 * @see com.vector.BO.BODatosCertificado#Buscar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public DatosCertificadoBean Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		return daocertificado.Buscar(datos);
	}

	/* (non-Javadoc)
	 * @see com.vector.BO.BODatosCertificado#Listar()
	 */
	@Override
	public List<DatosCertificadoBean> Listar(int id) {
		// TODO Auto-generated method stub
		return daocertificado.Listar(id);
	}

}
