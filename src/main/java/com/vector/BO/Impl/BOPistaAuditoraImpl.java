/**
 * BOPistaAuditoraImpl.java -- 17/10/2018
 */
package com.vector.BO.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.DAO.Impl.DAODatosPistaAuditoraImpl;
import com.vector.Utileria.Log;

/**
 * @author Claudio
 *WebServiceSGRH--com.vector.BO.Impl--BOPistaAuditoraImpl
 */
@Service
public class BOPistaAuditoraImpl extends Log implements BOPistaAuditora {
	@Autowired
	private DAODatosPistaAuditoraImpl pista;
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public void GrabarPistaAuditora(DatosPistaAuditoraBean datos) {
		/*Validaciones Pendientes*/
		info("Datos llegados"+datos.toString());
		pista.Crear(datos);

	}

}
