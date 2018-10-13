/**
 * DatosPersonalesBean4.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean4.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean de datos personales 4 extendido de datos personales 5
public class DatosPersonalesBean4 extends DatosPersonalesBean5{
	
	/** The colonia. */
	/*Variables de DatosPersonales*/
	@NotNull
	private String colonia="";
	
	/** The id telefono principal. */
	@NotNull
	private int idTelefonoPrincipal=0;
	
	/** The telefono principal. */
	@NotNull
	private String telefonoPrincipal="";
	
	/** The id telefono secundario. */
	@NotNull
	private int idTelefonoSecundario=0;
	
	/** The telefono secundario. */
	@NotNull
	private String telefonoSecundario="";
	
	/** The idtelefono emergencia. */
	@NotNull
	private int idtelefonoEmergencia=0;
	
	/** The Telefono emergencia. */
	@NotNull
	private String TelefonoEmergencia="";
	
	/** The id correo principal. */
	@NotNull
	private int idCorreoPrincipal=0;
	
	/** The correo principal. */
	@NotNull
	private String correoPrincipal="";
	
	/** The id correo secundario. */
	@NotNull
	private int idCorreoSecundario=0;
	
	/*Seccion de getters*/
	
	/**
	 * Gets the colonia.
	 *
	 * @return Obtienes el valor de colonia del tipo String
	 */
	
	public String getColonia() {
		return colonia;
	}
	
	/**
	 * Sets the colonia.
	 *
	 * @param colonia the new colonia
	 */
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	/**
	 * Gets the id telefono principal.
	 *
	 * @return Obtienes el valor de idTelefonoPrincipal del tipo int
	 */
	
	public int getIdTelefonoPrincipal() {
		return idTelefonoPrincipal;
	}
	
	/**
	 * Sets the id telefono principal.
	 *
	 * @param idTelefonoPrincipal the new id telefono principal
	 */
	
	public void setIdTelefonoPrincipal(int idTelefonoPrincipal) {
		this.idTelefonoPrincipal = idTelefonoPrincipal;
	}
	
	/**
	 * Gets the telefono principal.
	 *
	 * @return Obtienes el valor de telefonoPrincipal del tipo String
	 */
	
	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}
	
	/**
	 * Sets the telefono principal.
	 *
	 * @param telefonoPrincipal the new telefono principal
	 */
	
	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	
	/**
	 * Gets the id telefono secundario.
	 *
	 * @return Obtienes el valor de idTelefonoSecundario del tipo int
	 */
	
	public int getIdTelefonoSecundario() {
		return idTelefonoSecundario;
	}
	
	/**
	 * Sets the id telefono secundario.
	 *
	 * @param idTelefonoSecundario the new id telefono secundario
	 */
	
	public void setIdTelefonoSecundario(int idTelefonoSecundario) {
		this.idTelefonoSecundario = idTelefonoSecundario;
	}
	
	/**
	 * Gets the telefono secundario.
	 *
	 * @return Obtienes el valor de telefonoSecundario del tipo String
	 */
	
	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}
	
	/**
	 * Sets the telefono secundario.
	 *
	 * @param telefonoSecundario the new telefono secundario
	 */
	
	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}
	
	/**
	 * Gets the idtelefono emergencia.
	 *
	 * @return Obtienes el valor de idtelefonoEmergencia del tipo int
	 */
	
	public int getIdtelefonoEmergencia() {
		return idtelefonoEmergencia;
	}
	
	/**
	 * Sets the idtelefono emergencia.
	 *
	 * @param idtelefonoEmergencia the new idtelefono emergencia
	 */
	
	public void setIdtelefonoEmergencia(int idtelefonoEmergencia) {
		this.idtelefonoEmergencia = idtelefonoEmergencia;
	}
	
	/**
	 * Gets the telefono emergencia.
	 *
	 * @return Obtienes el valor de telefonoEmergencia del tipo String
	 */
	
	public String getTelefonoEmergencia() {
		return TelefonoEmergencia;
	}
	
	/**
	 * Sets the telefono emergencia.
	 *
	 * @param telefonoEmergencia the new telefono emergencia
	 */
	
	public void setTelefonoEmergencia(String telefonoEmergencia) {
		TelefonoEmergencia = telefonoEmergencia;
	}
	
	/**
	 * Gets the id correo principal.
	 *
	 * @return Obtienes el valor de idCorreoPrincipal del tipo int
	 */
	
	public int getIdCorreoPrincipal() {
		return idCorreoPrincipal;
	}
	
	/**
	 * Sets the id correo principal.
	 *
	 * @param idCorreoPrincipal the new id correo principal
	 */
	
	public void setIdCorreoPrincipal(int idCorreoPrincipal) {
		this.idCorreoPrincipal = idCorreoPrincipal;
	}
	
	/**
	 * Gets the correo principal.
	 *
	 * @return Obtienes el valor de correoPrincipal del tipo String
	 */
	
	public String getCorreoPrincipal() {
		return correoPrincipal;
	}
	
	/**
	 * Sets the correo principal.
	 *
	 * @param correoPrincipal the new correo principal
	 */
	
	public void setCorreoPrincipal(String correoPrincipal) {
		this.correoPrincipal = correoPrincipal;
	}
	
	/**
	 * Gets the id correo secundario.
	 *
	 * @return Obtienes el valor de idCorreoSecundario del tipo int
	 */
	
	public int getIdCorreoSecundario() {
		return idCorreoSecundario;
	}
	
	/**
	 * Sets the id correo secundario.
	 *
	 * @param idCorreoSecundario the new id correo secundario
	 */
	
	public void setIdCorreoSecundario(int idCorreoSecundario) {
		this.idCorreoSecundario = idCorreoSecundario;
	}
	

}
