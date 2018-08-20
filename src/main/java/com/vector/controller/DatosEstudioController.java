/**
 * 
 */
package com.vector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.vector.BO.BODatosEstudio;
import com.vector.Beans.DatosEstudioBean;

/**
 * @author Claudio
 *
 */
@RestController
public class DatosEstudioController {
	
	
	@Autowired
	private BODatosEstudio estudio;
	
	@RequestMapping(value = "/DatosEstudio/insertarestudio", method = RequestMethod.POST)
	public ResponseEntity<String> insertar(@RequestBody DatosEstudioBean datos){
		return new ResponseEntity<String>(estudio.Crear(datos),HttpStatus.OK);
	}
	
	
	
}
