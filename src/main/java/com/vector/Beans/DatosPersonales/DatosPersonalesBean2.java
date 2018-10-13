/**
 * DatosPersonalesBean2.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean2.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean de datos personales 2 estendido de datos personales 3
public class DatosPersonalesBean2 extends DatosPersonalesBean3{
	
	/** The url rfc. */
	/*Variables de DatosPersonales*/
	@NotNull
	private String urlRfc="";
	
	/** The c URP. */
	@NotNull
	private String cURP="";
	
	/** The urlc URP. */
	@NotNull
	private String urlcURP="";
	
	/** The idpasaporte. */
	@NotNull
	private int idpasaporte=0;
	
	/** The id visa. */
	@NotNull
	private int idVisa=0;
	
	/** The id edo civil. */
	@NotNull
	private int idEdoCivil=0;
	
	/** The seguro social. */
	@NotNull
	private String seguroSocial="";
	
	/** The url seguro social. */
	@NotNull
	private String urlSeguroSocial="";
	
	/** The id infonavit. */
	@NotNull
	private int idInfonavit=0;
	
	/** The id disponibilidad viajar. */
	@NotNull
	private int idDisponibilidadViajar=0;
	
	
	/*Seccion de getters*/
	
	/**
	 * Gets the url rfc.
	 *
	 * @return Obtienes el valor de urlRfc del tipo String
	 */
	
	public String getUrlRfc() {
		return urlRfc;
	}
	
	/**
	 * Sets the url rfc.
	 *
	 * @param urlRfc the new url rfc
	 */
	
	public void setUrlRfc(String urlRfc) {
		this.urlRfc = urlRfc;
	}
	
	/**
	 * Gets the c URP.
	 *
	 * @return Obtienes el valor de cURP del tipo String
	 */
	
	public String getcURP() {
		return cURP;
	}
	
	/**
	 * Sets the c URP.
	 *
	 * @param cURP the new c URP
	 */
	
	public void setcURP(String cURP) {
		this.cURP = cURP;
	}
	
	/**
	 * Gets the urlc URP.
	 *
	 * @return Obtienes el valor de urlcURP del tipo String
	 */
	
	public String getUrlcURP() {
		return urlcURP;
	}
	
	/**
	 * Sets the urlc URP.
	 *
	 * @param urlcURP the new urlc URP
	 */
	
	public void setUrlcURP(String urlcURP) {
		this.urlcURP = urlcURP;
	}
	
	/**
	 * Gets the idpasaporte.
	 *
	 * @return Obtienes el valor de idpasaporte del tipo int
	 */
	
	public int getIdpasaporte() {
		return idpasaporte;
	}
	
	/**
	 * Sets the idpasaporte.
	 *
	 * @param idpasaporte the new idpasaporte
	 */
	
	public void setIdpasaporte(int idpasaporte) {
		this.idpasaporte = idpasaporte;
	}
	
	/**
	 * Gets the id visa.
	 *
	 * @return Obtienes el valor de idVisa del tipo int
	 */
	
	public int getIdVisa() {
		return idVisa;
	}
	
	/**
	 * Sets the id visa.
	 *
	 * @param idVisa the new id visa
	 */
	
	public void setIdVisa(int idVisa) {
		this.idVisa = idVisa;
	}
	
	/**
	 * Gets the id edo civil.
	 *
	 * @return Obtienes el valor de idEdoCivil del tipo int
	 */
	
	public int getIdEdoCivil() {
		return idEdoCivil;
	}
	
	/**
	 * Sets the id edo civil.
	 *
	 * @param idEdoCivil the new id edo civil
	 */
	
	public void setIdEdoCivil(int idEdoCivil) {
		this.idEdoCivil = idEdoCivil;
	}
	
	/**
	 * Gets the seguro social.
	 *
	 * @return Obtienes el valor de seguroSocial del tipo String
	 */
	
	public String getSeguroSocial() {
		return seguroSocial;
	}
	
	/**
	 * Sets the seguro social.
	 *
	 * @param seguroSocial the new seguro social
	 */
	
	public void setSeguroSocial(String seguroSocial) {
		this.seguroSocial = seguroSocial;
	}
	
	/**
	 * Gets the url seguro social.
	 *
	 * @return Obtienes el valor de urlSeguroSocial del tipo String
	 */
	
	public String getUrlSeguroSocial() {
		return urlSeguroSocial;
	}
	
	/**
	 * Sets the url seguro social.
	 *
	 * @param urlSeguroSocial the new url seguro social
	 */
	
	public void setUrlSeguroSocial(String urlSeguroSocial) {
		this.urlSeguroSocial = urlSeguroSocial;
	}
	
	/**
	 * Gets the id infonavit.
	 *
	 * @return Obtienes el valor de idInfonavit del tipo int
	 */
	
	public int getIdInfonavit() {
		return idInfonavit;
	}
	
	/**
	 * Sets the id infonavit.
	 *
	 * @param idInfonavit the new id infonavit
	 */
	
	public void setIdInfonavit(int idInfonavit) {
		this.idInfonavit = idInfonavit;
	}
	
	/**
	 * Gets the id disponibilidad viajar.
	 *
	 * @return Obtienes el valor de idDisponibilidadViajar del tipo int
	 */
	
	public int getIdDisponibilidadViajar() {
		return idDisponibilidadViajar;
	}
	
	/**
	 * Sets the id disponibilidad viajar.
	 *
	 * @param idDisponibilidadViajar the new id disponibilidad viajar
	 */
	
	public void setIdDisponibilidadViajar(int idDisponibilidadViajar) {
		this.idDisponibilidadViajar = idDisponibilidadViajar;
	}
}
