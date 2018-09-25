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

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Utileria--MetodoError
 */
@Controller
public class MetodoError {
private static final String ruta = "/error";
@RequestMapping(value=ruta, method=RequestMethod.POST)
public ResponseEntity<MsgBean> error(HttpServletRequest request, HttpServletResponse response){
	System.out.println("Ruta de WS no valida");
	MsgBean mensaje = new MsgBean();
	mensaje.setMsjAccion(new EnvioMensaje().getRutaInvalida());
return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);	
} 
}
