/**
 * DatosCorreoAltBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosCorreoAltBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 *
 */
//Clase Bean para los datos de correo alternativo
public class DatosCorreoAltBean extends DatosInicioSesionBean {
	
	/** The idtipocorreo. */
	//Variable para declara los getter y setter de correo alternativo
	@NotNull
	private int idtipocorreo=0;
	
	/** The correo nw. */
	@NotNull
	private String correoNw="";
	
	/** The idpersona. */
	@NotNull
	private long idpersona=0;
	
	/** The correo lt. */
	@NotNull
	private String correoLt="";
	
	/** The Nombre completo. */
	@NotNull
	private String NombreCompleto = "";
	
	
	// declaracion de getters y setters
	/**
	 * Gets the idtipocorreo.
	 *
	 * @return Obtienes el valor de idtipocorreo del tipo int
	 */
	
	public int getIdtipocorreo() {
		return idtipocorreo;
	}
	
	/**
	 * Sets the idtipocorreo.
	 *
	 * @param idtipocorreo the new idtipocorreo
	 */
	
	public void setIdtipocorreo(int idtipocorreo) {
		this.idtipocorreo = idtipocorreo;
	}
	
	/**
	 * Gets the correo nw.
	 *
	 * @return Obtienes el valor de correoNw del tipo String
	 */
	
	public String getCorreoNw() {
		return correoNw;
	}
	
	/**
	 * Sets the correo nw.
	 *
	 * @param correoNw the new correo nw
	 */
	
	public void setCorreoNw(String correoNw) {
		this.correoNw = correoNw;
	}
	
	/**
	 * Gets the idpersona.
	 *
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * Sets the idpersona.
	 *
	 * @param idpersona the new idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * Gets the correo lt.
	 *
	 * @return Obtienes el valor de correoLt del tipo String
	 */
	
	public String getCorreoLt() {
		return correoLt;
	}
	
	/**
	 * Sets the correo lt.
	 *
	 * @param correoLt the new correo lt
	 */
	
	public void setCorreoLt(String correoLt) {
		this.correoLt = correoLt;
	}
	
	/**
	 * Gets the nombre completo.
	 *
	 * @return Obtienes el valor de nombreCompleto del tipo String
	 */
	
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	
	/**
	 * Sets the nombre completo.
	 *
	 * @param nombreCompleto the new nombre completo
	 */
	
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	
	//SECCION DE GETTERS AND SETTERS
	
}
