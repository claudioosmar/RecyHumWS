/**
 * DatosTelefonoAltBean.java -- 30/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosTelefonoAltBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de telefonos alternativos
public class DatosTelefonoAltBean {
	
	/** The idtipotelefono. */
	//Variable para declara los getter y setter de telefono alternativo
	@NotNull
	private int idtipotelefono=0;
	
	/** The telefono nw. */
	@NotNull
	private String telefonoNw="";
	
	/** The idpersona. */
	@NotNull
	private long idpersona=0;
	
	/** The telefono lt. */
	@NotNull
	private String telefonoLt="";
	
	/** The Nombre completo. */
	@NotNull
	private String NombreCompleto="";
	
	// declaracion de getters y setters
	
	/**
	 * Gets the idtipotelefono.
	 *
	 * @return Obtienes el valor de idtipotelefono del tipo int
	 */
	
	public int getIdtipotelefono() {
		return idtipotelefono;
	}
	
	/**
	 * Sets the idtipotelefono.
	 *
	 * @param idtipotelefono the new idtipotelefono
	 */
	
	public void setIdtipotelefono(int idtipotelefono) {
		this.idtipotelefono = idtipotelefono;
	}
	
	/**
	 * Gets the telefono nw.
	 *
	 * @return Obtienes el valor de telefonoNw del tipo String
	 */
	
	public String getTelefonoNw() {
		return telefonoNw;
	}
	
	/**
	 * Sets the telefono nw.
	 *
	 * @param telefonoNw the new telefono nw
	 */
	
	public void setTelefonoNw(String telefonoNw) {
		this.telefonoNw = telefonoNw;
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
	 * Gets the telefono lt.
	 *
	 * @return Obtienes el valor de telefonoLt del tipo String
	 */
	
	public String getTelefonoLt() {
		return telefonoLt;
	}
	
	/**
	 * Sets the telefono lt.
	 *
	 * @param telefonoLt the new telefono lt
	 */
	
	public void setTelefonoLt(String telefonoLt) {
		this.telefonoLt = telefonoLt;
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
	
	
}
