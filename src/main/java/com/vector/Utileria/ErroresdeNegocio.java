/**
 * 
 */
package com.vector.Utileria;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@ControllerAdvice
public class ErroresdeNegocio {
	 
	@ExceptionHandler(java.sql.SQLException.class) 
	public ResponseEntity<MsgBean> SQLException (HttpServletRequest request, SQLException e) {
        MsgBean mensaje = new MsgBean();
        mensaje.setMsjAccion(e.getMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class) 
	public ResponseEntity<MsgBean> HttpMessageNotReadableException (HttpServletRequest request, org.springframework.http.converter.HttpMessageNotReadableException e){
		MsgBean mensaje = new MsgBean();
        mensaje.setMsjAccion("Falta 1 o mas datos en el JSON favor de verificar");
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(java.lang.IllegalStateException.class)
	public ResponseEntity<MsgBean> IllegalStateException (HttpServletRequest request, java.lang.IllegalStateException e){
		MsgBean mensaje = new MsgBean();
        mensaje.setMsjAccion(e.getMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NullPointerException.class)
	public ResponseEntity<MsgBean> NullPointerException(HttpServletRequest request, java.lang.NullPointerException e){
		MsgBean mensaje = new MsgBean();
        mensaje.setMsjAccion(e.getMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
}
