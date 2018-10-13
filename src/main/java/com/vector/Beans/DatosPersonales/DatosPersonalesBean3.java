/**
 * DatosPersonalesBean3.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean3.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean de datos personales 3 extendido de datos personales 4
public class DatosPersonalesBean3 extends DatosPersonalesBean4{
	
	/** The id disponibilidad cambio. */
	/*Variables de DatosPersonales*/
	@NotNull
	private int idDisponibilidadCambio=0;
	
	/** The nacionalidad. */
	@NotNull
	private String nacionalidad="";
	
	/** The resumen. */
	@NotNull
	private String resumen="";
	
	/** The Objetivo laboral. */
	@NotNull
	private String ObjetivoLaboral="";
	
	/** The calle. */
	@NotNull
	private String calle="";
	
	/** The numero exterior. */
	@NotNull
	private String numeroExterior="";
	
	/** The numero interior. */
	@NotNull
	private String numeroInterior="";
	
	/** The id codigo postal. */
	@NotNull
	private int idCodigoPostal=0;
	
	/** The pais. */
	@NotNull
	private String pais="";
	
	/** The idmunicipio. */
	@NotNull
	private String idmunicipio="";
	
	/*Seccion de getters*/
	/**
	 * Gets the id disponibilidad cambio.
	 *
	 * @return Obtienes el valor de idDisponibilidadCambio del tipo int
	 */
	
	public int getIdDisponibilidadCambio() {
		return idDisponibilidadCambio;
	}
	
	/**
	 * Sets the id disponibilidad cambio.
	 *
	 * @param idDisponibilidadCambio the new id disponibilidad cambio
	 */
	
	public void setIdDisponibilidadCambio(int idDisponibilidadCambio) {
		this.idDisponibilidadCambio = idDisponibilidadCambio;
	}
	
	/**
	 * Gets the nacionalidad.
	 *
	 * @return Obtienes el valor de nacionalidad del tipo String
	 */
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	/**
	 * Sets the nacionalidad.
	 *
	 * @param nacionalidad the new nacionalidad
	 */
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	/**
	 * Gets the resumen.
	 *
	 * @return Obtienes el valor de resumen del tipo String
	 */
	
	public String getResumen() {
		return resumen;
	}
	
	/**
	 * Sets the resumen.
	 *
	 * @param resumen the new resumen
	 */
	
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	/**
	 * Gets the objetivo laboral.
	 *
	 * @return Obtienes el valor de objetivoLaboral del tipo String
	 */
	
	public String getObjetivoLaboral() {
		return ObjetivoLaboral;
	}
	
	/**
	 * Sets the objetivo laboral.
	 *
	 * @param objetivoLaboral the new objetivo laboral
	 */
	
	public void setObjetivoLaboral(String objetivoLaboral) {
		ObjetivoLaboral = objetivoLaboral;
	}
	
	/**
	 * Gets the calle.
	 *
	 * @return Obtienes el valor de calle del tipo String
	 */
	
	public String getCalle() {
		return calle;
	}
	
	/**
	 * Sets the calle.
	 *
	 * @param calle the new calle
	 */
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	/**
	 * Gets the numero exterior.
	 *
	 * @return Obtienes el valor de numeroExterior del tipo String
	 */
	
	public String getNumeroExterior() {
		return numeroExterior;
	}
	
	/**
	 * Sets the numero exterior.
	 *
	 * @param numeroExterior the new numero exterior
	 */
	
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	
	/**
	 * Gets the numero interior.
	 *
	 * @return Obtienes el valor de numeroInterior del tipo String
	 */
	
	public String getNumeroInterior() {
		return numeroInterior;
	}
	
	/**
	 * Sets the numero interior.
	 *
	 * @param numeroInterior the new numero interior
	 */
	
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	
	/**
	 * Gets the id codigo postal.
	 *
	 * @return Obtienes el valor de idCodigoPostal del tipo int
	 */
	
	public int getIdCodigoPostal() {
		return idCodigoPostal;
	}
	
	/**
	 * Sets the id codigo postal.
	 *
	 * @param idCodigoPostal the new id codigo postal
	 */
	
	public void setIdCodigoPostal(int idCodigoPostal) {
		this.idCodigoPostal = idCodigoPostal;
	}
	
	/**
	 * Gets the pais.
	 *
	 * @return Obtienes el valor de pais del tipo String
	 */
	
	public String getPais() {
		return pais;
	}
	
	/**
	 * Sets the pais.
	 *
	 * @param pais the new pais
	 */
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/**
	 * Gets the idmunicipio.
	 *
	 * @return Obtienes el valor de idmunicipio del tipo String
	 */
	
	public String getIdmunicipio() {
		return idmunicipio;
	}
	
	/**
	 * Sets the idmunicipio.
	 *
	 * @param idmunicipio the new idmunicipio
	 */
	
	public void setIdmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
	
}
