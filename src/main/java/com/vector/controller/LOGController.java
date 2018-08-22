/**
 * 
 */
package com.vector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosPistaAuditora;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.Model;
import com.vector.Beans.DatosPistaAuditoraBean;

/**
 * @author vectormx
 *
 */
@RestController
public class LOGController {
	@Autowired
	private BODatosPistaAuditora LOG;
	
	@RequestMapping(value="/log")
	public String AgregaAceso(@RequestBody DatosPistaAuditoraBean datos) {
		return LOG.agregaraceso(datos);
	}
	

}
