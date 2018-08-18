/**
 * 
 */
package com.vector.BO.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.PistaAuditoraBean;
import com.vector.DAO.DAOPistaAuditora;

/**
 * @author vectormx
 *
 */
@Service
public class BoPistaAuditoraImpl implements BOPistaAuditora {
@Autowired
private DAOPistaAuditora LOG;
	/* (non-Javadoc)
	 * @see com.vector.BO.BOPistaAuditora#agregaraceso(com.vector.Beans.PistaAuditoraBean)
	 */
	@Override
	public String agregaraceso(PistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		return LOG.agregaracceso(datos);
	}

}
