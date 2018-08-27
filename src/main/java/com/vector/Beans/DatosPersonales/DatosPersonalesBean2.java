/**
 * DatosPersonalesBean2.java -- 25/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean2
 */
public class DatosPersonalesBean2 extends DatosPersonalesBean3 {
	/*Variables de DatosPersonales*/
	@NotNull
	private String urlRfc="";
	@NotNull
	private String cURP="";
	@NotNull
	private String urlcURP="";
	@NotNull
	private int idpasaporte=0;
	@NotNull
	private int idVisa=0;
	@NotNull
	private int idEdoCivil=0;
	@NotNull
	private String seguroSocial="";
	@NotNull
	private String urlSeguroSocial="";
	@NotNull
	private int idInfonavit=0;
	@NotNull
	private int idDisponibilidadViajar=0;
	
	
	/*Seccion de getters*/
	/**
	 * @return Obtienes el valor de urlRfc
	 */
	
	public String getUrlRfc() {
		return urlRfc;
	}
	
	/**
	 * @return Obtienes el valor de cURP
	 */
	
	public String getcURP() {
		return cURP;
	}
	
	/**
	 * @return Obtienes el valor de urlcURP
	 */
	
	public String getUrlcURP() {
		return urlcURP;
	}
	
	/**
	 * @return Obtienes el valor de idpasaporte
	 */
	
	public int getIdpasaporte() {
		return idpasaporte;
	}
	
	/**
	 * @return Obtienes el valor de idVisa
	 */
	
	public int getIdVisa() {
		return idVisa;
	}
	
	/**
	 * @return Obtienes el valor de idEdoCivil
	 */
	
	public int getIdEdoCivil() {
		return idEdoCivil;
	}
	
	/**
	 * @return Obtienes el valor de seguroSocial
	 */
	
	public String getSeguroSocial() {
		return seguroSocial;
	}
	
	/**
	 * @return Obtienes el valor de urlSeguroSocial
	 */
	
	public String getUrlSeguroSocial() {
		return urlSeguroSocial;
	}
	
	/**
	 * @return Obtienes el valor de idInfonavit
	 */
	
	public int getIdInfonavit() {
		return idInfonavit;
	}
	
	/**
	 * @return Obtienes el valor de idDisponibilidadViajar
	 */
	
	public int getIdDisponibilidadViajar() {
		return idDisponibilidadViajar;
	}

	/*Seccion se Setters*/
	
	/**
	 * @param Agregar el valor a urlRfc
	 */
	
	public void setUrlRfc(String urlRfc) {
		this.urlRfc = urlRfc;
	}

	
	/**
	 * @param Agregar el valor a cURP
	 */
	
	public void setcURP(String cURP) {
		this.cURP = cURP;
	}

	
	/**
	 * @param Agregar el valor a urlcURP
	 */
	
	public void setUrlcURP(String urlcURP) {
		this.urlcURP = urlcURP;
	}

	
	/**
	 * @param Agregar el valor a idpasaporte
	 */
	
	public void setIdpasaporte(int idpasaporte) {
		this.idpasaporte = idpasaporte;
	}

	
	/**
	 * @param Agregar el valor a idVisa
	 */
	
	public void setIdVisa(int idVisa) {
		this.idVisa = idVisa;
	}

	
	/**
	 * @param Agregar el valor a idEdoCivil
	 */
	
	public void setIdEdoCivil(int idEdoCivil) {
		this.idEdoCivil = idEdoCivil;
	}

	
	/**
	 * @param Agregar el valor a seguroSocial
	 */
	
	public void setSeguroSocial(String seguroSocial) {
		this.seguroSocial = seguroSocial;
	}

	
	/**
	 * @param Agregar el valor a urlSeguroSocial
	 */
	
	public void setUrlSeguroSocial(String urlSeguroSocial) {
		this.urlSeguroSocial = urlSeguroSocial;
	}

	
	/**
	 * @param Agregar el valor a idInfonavit
	 */
	
	public void setIdInfonavit(int idInfonavit) {
		this.idInfonavit = idInfonavit;
	}

	
	/**
	 * @param Agregar el valor a idDisponibilidadViajar
	 */
	
	public void setIdDisponibilidadViajar(int idDisponibilidadViajar) {
		this.idDisponibilidadViajar = idDisponibilidadViajar;
	}
	
	
	
}
