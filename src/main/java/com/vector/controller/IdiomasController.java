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

import com.vector.BO.BOIdiomas;
import com.vector.Beans.DatosIdiomasBean;

/**
 * @author vectormx
 *
 */
@RestController
public class IdiomasController {

	@Autowired
	private BOIdiomas idioma;
	
	@RequestMapping(value = "/Datosidiomamas/insertaridioma", method = RequestMethod.POST)
	public ResponseEntity<String> insertar(@RequestBody DatosIdiomasBean datos){
		return new ResponseEntity<String>(idioma.Crear(datos),HttpStatus.OK);
	}
}
