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
        System.out.println("SQLError");
        if(e.getErrorCode()==17289) {
        	mensaje.setMsjAccion("No Se econtraron Datos");
        }else if(e.getErrorCode()==17002) {
        	mensaje.setMsjAccion("Error indefinido de la red");
        }else if(e.getErrorCode()==0) {
        	mensaje.setMsjAccion("Error en la conexion a la base de datos");
        }else {
        	mensaje.setMsjAccion(e.getMessage()+"--"+e.getErrorCode());	
        }
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class) 
	public ResponseEntity<MsgBean> HttpMessageNotReadableException (HttpServletRequest request, org.springframework.http.converter.HttpMessageNotReadableException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("HTTPMessageno");
        mensaje.setMsjAccion("Falta 1 o mas datos en el JSON favor de verificar "+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(java.lang.IllegalStateException.class)
	public ResponseEntity<MsgBean> IllegalStateException (HttpServletRequest request, java.lang.IllegalStateException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("Ilegalloli");
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NullPointerException.class)
	public ResponseEntity<MsgBean> NullPointerException(HttpServletRequest request, java.lang.NullPointerException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("NullPointer");
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NumberFormatException.class)
	public ResponseEntity<MsgBean> NumberFormatException(HttpServletRequest request, java.lang.NumberFormatException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("Numverformartex");
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
}
