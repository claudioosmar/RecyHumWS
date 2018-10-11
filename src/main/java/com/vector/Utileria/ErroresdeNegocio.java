/**
 * 
 */
package com.vector.Utileria;


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
public class ErroresdeNegocio extends Log {
	 
	@ExceptionHandler(java.sql.SQLException.class) 
	public ResponseEntity<MsgBean> SQLException (HttpServletRequest request, java.sql.SQLException e) {
        MsgBean mensaje = new MsgBean();
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getErrorCode());	
        error("SQL ERROR "+mensaje.getMsjAccion());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class) 
	public ResponseEntity<MsgBean> HttpMessageNotReadableException (HttpServletRequest request, org.springframework.http.converter.HttpMessageNotReadableException e){
		MsgBean mensaje = new MsgBean();
		error("HttpMessageNotReadable -- "+e.getMessage());
        mensaje.setMsjAccion("ERROR "+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(java.lang.IllegalStateException.class)
	public ResponseEntity<MsgBean> IllegalStateException (HttpServletRequest request, java.lang.IllegalStateException e){
		MsgBean mensaje = new MsgBean();
		error("IllegalState -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NullPointerException.class)
	public ResponseEntity<MsgBean> NullPointerException(HttpServletRequest request, java.lang.NullPointerException e){
		MsgBean mensaje = new MsgBean();
		error("NullPointer -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NumberFormatException.class)
	public ResponseEntity<MsgBean> NumberFormatException(HttpServletRequest request, java.lang.NumberFormatException e){
		MsgBean mensaje = new MsgBean();
		error("NumberFormat -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}

}
