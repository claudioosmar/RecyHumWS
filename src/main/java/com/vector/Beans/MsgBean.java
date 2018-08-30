/**
 * MsgBean.java -- 30/08/2018
 */
package com.vector.Beans;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--MsgBean
 */
// Clase Bean para control de errores
public class MsgBean {
	//variable para mandar mensaje
	private String MsjAccion="";

	// getter y setter para retornar mensaje
	/**
	 * @return Obtienes el valor de msjAccion del tipo String
	 */
	
	public String getMsjAccion() {
		return MsjAccion;
	}

	
	/**
	 * @param Agregar el valor a msjAccion del tipo String
	 */
	
	public void setMsjAccion(String msjAccion) {
		MsjAccion = msjAccion;
	}
	
	
}
