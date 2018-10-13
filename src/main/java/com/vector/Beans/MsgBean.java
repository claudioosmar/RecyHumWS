/**
 * MsgBean.java -- 30/08/2018
 */
package com.vector.Beans;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: MsgBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
// Clase Bean para control de errores
public class MsgBean {
	
	/** The Msj accion. */
	//variable para mandar mensaje
	private String MsjAccion="";

	// getter y setter para retornar mensaje
	/**
	 * Gets the msj accion.
	 *
	 * @return Obtienes el valor de msjAccion del tipo String
	 */
	
	public String getMsjAccion() {
		return MsjAccion;
	}

	
	/**
	 * Sets the msj accion.
	 *
	 * @param msjAccion the new msj accion
	 */
	
	public void setMsjAccion(String msjAccion) {
		MsjAccion = msjAccion;
	}
	
	
}
