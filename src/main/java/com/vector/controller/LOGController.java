/**
 * 
 */
package com.vector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BOPistaAuditora;
import com.vector.Beans.InicioSesionBean;
import com.vector.Beans.Model;
import com.vector.Beans.PistaAuditoraBean;

/**
 * @author vectormx
 *
 */
@RestController
public class LOGController {
	@Autowired
	private BOPistaAuditora LOG;
	
	@RequestMapping(value="/log")
	public String AgregaAceso(@RequestBody PistaAuditoraBean datos) {
		return LOG.agregaraceso(datos);
	}
	

}
