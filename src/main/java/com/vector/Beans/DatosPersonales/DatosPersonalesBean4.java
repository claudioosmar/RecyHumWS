/**
 * DatosPersonalesBean4.java -- 25/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean4
 */
public class DatosPersonalesBean4 extends DatosPersonalesBean5 {
	/*Variables de DatosPersonales*/
	@NotNull
	private String colonia="";
	@NotNull
	private int idTelefonoPrincipal=0;
	@NotNull
	private String telefonoPrincipal="";
	@NotNull
	private int idTelefonoSecundario=0;
	@NotNull
	private String telefonoSecundario="";
	@NotNull
	private int idtelefonoEmergencia=0;
	@NotNull
	private String TelefonoEmergencia="";
	@NotNull
	private int idCorreoPrincipal=0;
	@NotNull
	private String correoPrincipal="";
	@NotNull
	private int idCorreoSecundario=0;
	
	/*Seccion de getters*/
	/**
	 * @return Obtienes el valor de colonia
	 */
	
	public String getColonia() {
		return colonia;
	}
	
	/**
	 * @return Obtienes el valor de idTelefonoPrincipal
	 */
	
	public int getIdTelefonoPrincipal() {
		return idTelefonoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de telefonoPrincipal
	 */
	
	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de idTelefonoSecundario
	 */
	
	public int getIdTelefonoSecundario() {
		return idTelefonoSecundario;
	}
	
	/**
	 * @return Obtienes el valor de telefonoSecundario
	 */
	
	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}
	
	/**
	 * @return Obtienes el valor de idTelefonoEmergencia
	 */
	
	public int getIdTelefonoEmergencia() {
		return idtelefonoEmergencia;
	}
	
	/**
	 * @return Obtienes el valor de telefonoEmergencia
	 */
	
	public String getTelefonoEmergencia() {
		return TelefonoEmergencia;
	}
	
	/**
	 * @return Obtienes el valor de idCorreoPrincipal
	 */
	
	public int getIdCorreoPrincipal() {
		return idCorreoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de correoPrincipal
	 */
	
	public String getCorreoPrincipal() {
		return correoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de idCorreoSecundario
	 */
	
	public int getIdCorreoSecundario() {
		return idCorreoSecundario;
	}
	
	/*Seccion se Setters*/
	
	/**
	 * @param Agregar el valor a colonia
	 */
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	/**
	 * @param Agregar el valor a idTelefonoPrincipal
	 */
	
	public void setIdTelefonoPrincipal(int idTelefonoPrincipal) {
		this.idTelefonoPrincipal = idTelefonoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a telefonoPrincipal
	 */
	
	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a idTelefonoSecundario
	 */
	
	public void setIdTelefonoSecundario(int idTelefonoSecundario) {
		this.idTelefonoSecundario = idTelefonoSecundario;
	}
	
	/**
	 * @param Agregar el valor a telefonoSecundario
	 */
	
	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}
	
	/**
	 * @param Agregar el valor a idTelefonoEmergencia
	 */
	
	public void setIdTelefonoEmergencia(int idTelefonoEmergencia) {
		this.idtelefonoEmergencia = idTelefonoEmergencia;
	}
	
	/**
	 * @param Agregar el valor a telefonoEmergencia
	 */
	
	public void setTelefonoEmergencia(String telefonoEmergencia) {
		TelefonoEmergencia = telefonoEmergencia;
	}
	
	/**
	 * @param Agregar el valor a idCorreoPrincipal
	 */
	
	public void setIdCorreoPrincipal(int idCorreoPrincipal) {
		this.idCorreoPrincipal = idCorreoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a correoPrincipal
	 */
	
	public void setCorreoPrincipal(String correoPrincipal) {
		this.correoPrincipal = correoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a idCorreoSecundario
	 */
	
	public void setIdCorreoSecundario(int idCorreoSecundario) {
		this.idCorreoSecundario = idCorreoSecundario;
	}
	

}
