/**
 * DatosTelefonoAltBean.java -- 30/08/2018
 */
package com.vector.Beans;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosTelefonoAltBean
 */
//Clase Bean para los datos de telefonos alternativos
public class DatosTelefonoAltBean {
	//Variable para declara los getter y setter de telefono alternativo
	@NotNull
	private int idtipotelefono=0;
	@NotNull
	private String telefonoNw="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private String telefonoLt="";
	@NotNull
	private String NombreCompleto="";
	
	// declaracion de getters y setters
	
	/**
	 * @return Obtienes el valor de idtipotelefono del tipo int
	 */
	
	public int getIdtipotelefono() {
		return idtipotelefono;
	}
	
	/**
	 * @param Agregar el valor a idtipotelefono del tipo int
	 */
	
	public void setIdtipotelefono(int idtipotelefono) {
		this.idtipotelefono = idtipotelefono;
	}
	
	/**
	 * @return Obtienes el valor de telefonoNw del tipo String
	 */
	
	public String getTelefonoNw() {
		return telefonoNw;
	}
	
	/**
	 * @param Agregar el valor a telefonoNw del tipo String
	 */
	
	public void setTelefonoNw(String telefonoNw) {
		this.telefonoNw = telefonoNw;
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
	 * @return Obtienes el valor de telefonoLt del tipo String
	 */
	
	public String getTelefonoLt() {
		return telefonoLt;
	}
	
	/**
	 * @param Agregar el valor a telefonoLt del tipo String
	 */
	
	public void setTelefonoLt(String telefonoLt) {
		this.telefonoLt = telefonoLt;
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
	
	
}
