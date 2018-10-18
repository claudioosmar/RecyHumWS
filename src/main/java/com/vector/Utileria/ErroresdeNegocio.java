/**
 * 
 */
package com.vector.Utileria;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vector.Beans.MsgBean;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: ErroresdeNegocio.java
 *   Descripción:  contiene el control de errores
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@ControllerAdvice
public class ErroresdeNegocio extends Log {
	 
	/**
	 * Clase: SQLException 
	 * Descripcion:.
	 *
	 * @param request Tipo de Dato resivido HttpServletRequest
	 * @param e Tipo de Dato resivido SQLException
	 * @return Retorna response entity
	 */
	@ExceptionHandler(java.sql.SQLException.class) 
	public ResponseEntity<MsgBean> SQLException (HttpServletRequest request, java.sql.SQLException e) {
        MsgBean mensaje = new MsgBean();
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getErrorCode());	
        error("SQL ERROR "+mensaje.getMsjAccion());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Clase: HttpMessageNotReadableException 
	 * Descripcion:.
	 *
	 * @param request Tipo de Dato resivido HttpServletRequest
	 * @param e Tipo de Dato resivido HttpMessageNotReadableException
	 * @return Retorna response entity
	 */
	@ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class) 
	public ResponseEntity<MsgBean> HttpMessageNotReadableException (HttpServletRequest request, org.springframework.http.converter.HttpMessageNotReadableException e){
		MsgBean mensaje = new MsgBean();
		error("HttpMessageNotReadable -- "+e.getMessage());
        mensaje.setMsjAccion("ERROR "+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Clase: IllegalStateException 
	 * Descripcion:.
	 *
	 * @param request Tipo de Dato resivido HttpServletRequest
	 * @param e Tipo de Dato resivido IllegalStateException
	 * @return Retorna response entity
	 */
	@ExceptionHandler(java.lang.IllegalStateException.class)
	public ResponseEntity<MsgBean> IllegalStateException (HttpServletRequest request, java.lang.IllegalStateException e){
		MsgBean mensaje = new MsgBean();
		error("IllegalState -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Clase: NullPointerException 
	 * Descripcion:.
	 *
	 * @param request Tipo de Dato resivido HttpServletRequest
	 * @param e Tipo de Dato resivido NullPointerException
	 * @return Retorna response entity
	 */
	@ExceptionHandler(java.lang.NullPointerException.class)
	public ResponseEntity<MsgBean> NullPointerException(HttpServletRequest request, java.lang.NullPointerException e){
		MsgBean mensaje = new MsgBean();
		error("NullPointer -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Clase: NumberFormatException 
	 * Descripcion:.
	 *
	 * @param request Tipo de Dato resivido HttpServletRequest
	 * @param e Tipo de Dato resivido NumberFormatException
	 * @return Retorna response entity
	 */
	@ExceptionHandler(java.lang.NumberFormatException.class)
	public ResponseEntity<MsgBean> NumberFormatException(HttpServletRequest request, java.lang.NumberFormatException e){
		MsgBean mensaje = new MsgBean();
		error("NumberFormat -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> MissingServletRequestParameterException(HttpServletRequest request,org.springframework.web.bind.MethodArgumentNotValidException e){
          List<String> errores = new ArrayList<>();
          BindingResult result = e.getBindingResult();
          for (int i = 0; i < result.getAllErrors().size(); i++) {
                 errores.add(result.getAllErrors().get(i).getDefaultMessage());
          }
          return new ResponseEntity<List<String>>(errores,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(org.springframework.validation.BindException.class)
    public ResponseEntity<List<String>> BindException(HttpServletRequest request,org.springframework.validation.BindException e){
          List<String> errores = new ArrayList<>();
          for (int i = 0; i < e.getAllErrors().size(); i++) {
                 errores.add(e.getAllErrors().get(i).getDefaultMessage());
          }
          return new ResponseEntity<List<String>>(errores,HttpStatus.BAD_REQUEST);
    }

}
