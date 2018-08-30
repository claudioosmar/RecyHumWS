/**
 * DatosCorreoAltBean.java -- 29/08/2018
 */
package com.vector.Beans;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosCorreoAltBean
 */
//Clase Bean para los datos de correo alternativo
public class DatosCorreoAltBean {
	//Variable para declara los getter y setter de correo alternativo
	@NotNull
	private int idtipocorreo=0;
	@NotNull
	private String correoNw="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private String correoLt="";
	@NotNull
	private String NombreCompleto = "";
	
	
	// declaracion de getters y setters
	/**
	 * @return Obtienes el valor de idtipocorreo del tipo int
	 */
	
	public int getIdtipocorreo() {
		return idtipocorreo;
	}
	
	/**
	 * @param Agregar el valor a idtipocorreo del tipo int
	 */
	
	public void setIdtipocorreo(int idtipocorreo) {
		this.idtipocorreo = idtipocorreo;
	}
	
	/**
	 * @return Obtienes el valor de correoNw del tipo String
	 */
	
	public String getCorreoNw() {
		return correoNw;
	}
	
	/**
	 * @param Agregar el valor a correoNw del tipo String
	 */
	
	public void setCorreoNw(String correoNw) {
		this.correoNw = correoNw;
	}
	
	/**
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona del tipo long
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * @return Obtienes el valor de correoLt del tipo String
	 */
	
	public String getCorreoLt() {
		return correoLt;
	}
	
	/**
	 * @param Agregar el valor a correoLt del tipo String
	 */
	
	public void setCorreoLt(String correoLt) {
		this.correoLt = correoLt;
	}
	
	/**
	 * @return Obtienes el valor de nombreCompleto del tipo String
	 */
	
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	
	/**
	 * @param Agregar el valor a nombreCompleto del tipo String
	 */
	
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	
	//SECCION DE GETTERS AND SETTERS
	
}
