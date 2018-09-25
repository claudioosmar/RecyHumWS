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
public class ErroresdeNegocio {
	 
	@ExceptionHandler(java.sql.SQLException.class) 
	public ResponseEntity<MsgBean> SQLException (HttpServletRequest request, java.sql.SQLException e) {
        MsgBean mensaje = new MsgBean();
        System.out.println("SQL-- "+e.getMessage());
        if(e.getErrorCode()==17289) {
        	mensaje.setMsjAccion("No Se econtraron Datos");
        }else if(e.getErrorCode()==17002) {
        	mensaje.setMsjAccion("Error indefinido de la red");
        }else if(e.getErrorCode()==17003) {
        	mensaje.setMsjAccion("Índice de columna inválido");
        }else if(e.getErrorCode()==0) {
        	mensaje.setMsjAccion("Error en la conexion a la base de datos");
        }else if(e.getErrorCode()==1858){
        	mensaje.setMsjAccion("encontró un carácte no numérico donde se esperaba un número");
        }else if(e.getErrorCode()==1861){
        	mensaje.setMsjAccion("Formato enviado no coincide con la cadena de formato");
        }else if(e.getErrorCode()==01400){
        	mensaje.setMsjAccion("No se puede introducir un nulo en una variable no nulo");
        }else if(e.getErrorCode()==1438){
        	mensaje.setMsjAccion("Valor mayor a lo permitido");
        }else if(e.getErrorCode()==2291){
        	mensaje.setMsjAccion("restricción de integridad, clave principal no encontrada");
        }else if(e.getErrorCode()==01407){
        	mensaje.setMsjAccion("No puedes actualizar para un dato nulo");
        }else if(e.getErrorCode()==01002){
        	mensaje.setMsjAccion("Búsqueda fuera de secuencia");
        }else if(e.getErrorCode()==17289){
        	mensaje.setMsjAccion("Errores en la consulta");
        }else if(e.getErrorCode()==2291||e.getErrorCode()==00001){
        	mensaje.setMsjAccion("Error al mandar a llamar un id no exitente en la Base de datos");
        }else if(e.getErrorCode()==904){
        	mensaje.setMsjAccion("Identificador invalido");
        }else if(e.getErrorCode()==942){
        	mensaje.setMsjAccion("Tabla o vista no existente");
        }else if(e.getErrorCode()==957){
        	mensaje.setMsjAccion("Columnas duplicadas por el nombre");
        }else if(e.getErrorCode()==1847){
        	mensaje.setMsjAccion("el dia del mes debe estar entre el 1 y el ultimo dia del mes");
        }else if(e.getErrorCode()==911){
        	mensaje.setMsjAccion("Caracter invalido");
        }else if(e.getErrorCode()==01722){
        	mensaje.setMsjAccion("Número invalido");
        }else if(e.getErrorCode()==1400){
        	mensaje.setMsjAccion("Dato nulo que No puede ser nulo");
        }else if(e.getErrorCode()==17014||e.getErrorCode()==17273){
        	mensaje.setMsjAccion("Error Interno del Web Service");
        }else if(e.getErrorCode()==17014||e.getErrorCode()==933){
        	mensaje.setMsjAccion("Comando de SQL no apropiado revisar con tu proovedor de BD");
        }else {
        	mensaje.setMsjAccion(e.getMessage()+"--"+e.getErrorCode());	
        }
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class) 
	public ResponseEntity<MsgBean> HttpMessageNotReadableException (HttpServletRequest request, org.springframework.http.converter.HttpMessageNotReadableException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("HttpMessageNotReadable -- "+e.getMessage());
        mensaje.setMsjAccion("Falta 1 o mas datos en el JSON favor de verificar "+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(java.lang.IllegalStateException.class)
	public ResponseEntity<MsgBean> IllegalStateException (HttpServletRequest request, java.lang.IllegalStateException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("IllegalState -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NullPointerException.class)
	public ResponseEntity<MsgBean> NullPointerException(HttpServletRequest request, java.lang.NullPointerException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("NullPointer -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(java.lang.NumberFormatException.class)
	public ResponseEntity<MsgBean> NumberFormatException(HttpServletRequest request, java.lang.NumberFormatException e){
		MsgBean mensaje = new MsgBean();
		System.out.println("NumberFormat -- "+e.getMessage());
        mensaje.setMsjAccion(e.getMessage()+"--"+e.getLocalizedMessage());
		return new ResponseEntity<MsgBean>(mensaje,HttpStatus.BAD_REQUEST);
	}
}
