/**
 * DatosPersonalesBean4.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean4
 */
//Clase Bean de datos personales 4 extendido de datos personales 5
public class DatosPersonalesBean4 extends DatosPersonalesBean5{
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
	 * @return Obtienes el valor de colonia del tipo String
	 */
	
	public String getColonia() {
		return colonia;
	}
	
	/**
	 * @param Agregar el valor a colonia del tipo String
	 */
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	/**
	 * @return Obtienes el valor de idTelefonoPrincipal del tipo int
	 */
	
	public int getIdTelefonoPrincipal() {
		return idTelefonoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a idTelefonoPrincipal del tipo int
	 */
	
	public void setIdTelefonoPrincipal(int idTelefonoPrincipal) {
		this.idTelefonoPrincipal = idTelefonoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de telefonoPrincipal del tipo String
	 */
	
	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a telefonoPrincipal del tipo String
	 */
	
	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de idTelefonoSecundario del tipo int
	 */
	
	public int getIdTelefonoSecundario() {
		return idTelefonoSecundario;
	}
	
	/**
	 * @param Agregar el valor a idTelefonoSecundario del tipo int
	 */
	
	public void setIdTelefonoSecundario(int idTelefonoSecundario) {
		this.idTelefonoSecundario = idTelefonoSecundario;
	}
	
	/**
	 * @return Obtienes el valor de telefonoSecundario del tipo String
	 */
	
	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}
	
	/**
	 * @param Agregar el valor a telefonoSecundario del tipo String
	 */
	
	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}
	
	/**
	 * @return Obtienes el valor de idtelefonoEmergencia del tipo int
	 */
	
	public int getIdtelefonoEmergencia() {
		return idtelefonoEmergencia;
	}
	
	/**
	 * @param Agregar el valor a idtelefonoEmergencia del tipo int
	 */
	
	public void setIdtelefonoEmergencia(int idtelefonoEmergencia) {
		this.idtelefonoEmergencia = idtelefonoEmergencia;
	}
	
	/**
	 * @return Obtienes el valor de telefonoEmergencia del tipo String
	 */
	
	public String getTelefonoEmergencia() {
		return TelefonoEmergencia;
	}
	
	/**
	 * @param Agregar el valor a telefonoEmergencia del tipo String
	 */
	
	public void setTelefonoEmergencia(String telefonoEmergencia) {
		TelefonoEmergencia = telefonoEmergencia;
	}
	
	/**
	 * @return Obtienes el valor de idCorreoPrincipal del tipo int
	 */
	
	public int getIdCorreoPrincipal() {
		return idCorreoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a idCorreoPrincipal del tipo int
	 */
	
	public void setIdCorreoPrincipal(int idCorreoPrincipal) {
		this.idCorreoPrincipal = idCorreoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de correoPrincipal del tipo String
	 */
	
	public String getCorreoPrincipal() {
		return correoPrincipal;
	}
	
	/**
	 * @param Agregar el valor a correoPrincipal del tipo String
	 */
	
	public void setCorreoPrincipal(String correoPrincipal) {
		this.correoPrincipal = correoPrincipal;
	}
	
	/**
	 * @return Obtienes el valor de idCorreoSecundario del tipo int
	 */
	
	public int getIdCorreoSecundario() {
		return idCorreoSecundario;
	}
	
	/**
	 * @param Agregar el valor a idCorreoSecundario del tipo int
	 */
	
	public void setIdCorreoSecundario(int idCorreoSecundario) {
		this.idCorreoSecundario = idCorreoSecundario;
	}
	

}
