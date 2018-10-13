/**
 * MetodoError.java -- 03/09/2018
 */
package com.vector.Utileria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: MetodoError.java
 *   Descripción:  contiene mensaje de error del WS
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Controller
public class MetodoError extends Log{

/** The Constant ruta. */
private static final String ruta = "/error";

/**
 * Clase: error 
 * Descripcion:.
 *
 * @param request Tipo de Dato resivido HttpServletRequest
 * @param response Tipo de Dato resivido HttpServletResponse
 * @return Retorna response entity
 */
@RequestMapping(value=ruta, method=RequestMethod.POST)
public ResponseEntity<MsgBean> error(HttpServletRequest request, HttpServletResponse response){
	error("Ruta de WS no valida");
	MsgBean mensaje = new MsgBean();
	mensaje.setMsjAccion(new EnvioMensaje().getRutaInvalida());
return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);	
} 
}
