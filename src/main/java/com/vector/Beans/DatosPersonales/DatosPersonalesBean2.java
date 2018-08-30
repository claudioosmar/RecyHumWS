/**
 * DatosPersonalesBean2.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean2
 */
//Clase Bean de datos personales 2 estendido de datos personales 3
public class DatosPersonalesBean2 extends DatosPersonalesBean3{
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
	 * @return Obtienes el valor de urlRfc del tipo String
	 */
	
	public String getUrlRfc() {
		return urlRfc;
	}
	
	/**
	 * @param Agregar el valor a urlRfc del tipo String
	 */
	
	public void setUrlRfc(String urlRfc) {
		this.urlRfc = urlRfc;
	}
	
	/**
	 * @return Obtienes el valor de cURP del tipo String
	 */
	
	public String getcURP() {
		return cURP;
	}
	
	/**
	 * @param Agregar el valor a cURP del tipo String
	 */
	
	public void setcURP(String cURP) {
		this.cURP = cURP;
	}
	
	/**
	 * @return Obtienes el valor de urlcURP del tipo String
	 */
	
	public String getUrlcURP() {
		return urlcURP;
	}
	
	/**
	 * @param Agregar el valor a urlcURP del tipo String
	 */
	
	public void setUrlcURP(String urlcURP) {
		this.urlcURP = urlcURP;
	}
	
	/**
	 * @return Obtienes el valor de idpasaporte del tipo int
	 */
	
	public int getIdpasaporte() {
		return idpasaporte;
	}
	
	/**
	 * @param Agregar el valor a idpasaporte del tipo int
	 */
	
	public void setIdpasaporte(int idpasaporte) {
		this.idpasaporte = idpasaporte;
	}
	
	/**
	 * @return Obtienes el valor de idVisa del tipo int
	 */
	
	public int getIdVisa() {
		return idVisa;
	}
	
	/**
	 * @param Agregar el valor a idVisa del tipo int
	 */
	
	public void setIdVisa(int idVisa) {
		this.idVisa = idVisa;
	}
	
	/**
	 * @return Obtienes el valor de idEdoCivil del tipo int
	 */
	
	public int getIdEdoCivil() {
		return idEdoCivil;
	}
	
	/**
	 * @param Agregar el valor a idEdoCivil del tipo int
	 */
	
	public void setIdEdoCivil(int idEdoCivil) {
		this.idEdoCivil = idEdoCivil;
	}
	
	/**
	 * @return Obtienes el valor de seguroSocial del tipo String
	 */
	
	public String getSeguroSocial() {
		return seguroSocial;
	}
	
	/**
	 * @param Agregar el valor a seguroSocial del tipo String
	 */
	
	public void setSeguroSocial(String seguroSocial) {
		this.seguroSocial = seguroSocial;
	}
	
	/**
	 * @return Obtienes el valor de urlSeguroSocial del tipo String
	 */
	
	public String getUrlSeguroSocial() {
		return urlSeguroSocial;
	}
	
	/**
	 * @param Agregar el valor a urlSeguroSocial del tipo String
	 */
	
	public void setUrlSeguroSocial(String urlSeguroSocial) {
		this.urlSeguroSocial = urlSeguroSocial;
	}
	
	/**
	 * @return Obtienes el valor de idInfonavit del tipo int
	 */
	
	public int getIdInfonavit() {
		return idInfonavit;
	}
	
	/**
	 * @param Agregar el valor a idInfonavit del tipo int
	 */
	
	public void setIdInfonavit(int idInfonavit) {
		this.idInfonavit = idInfonavit;
	}
	
	/**
	 * @return Obtienes el valor de idDisponibilidadViajar del tipo int
	 */
	
	public int getIdDisponibilidadViajar() {
		return idDisponibilidadViajar;
	}
	
	/**
	 * @param Agregar el valor a idDisponibilidadViajar del tipo int
	 */
	
	public void setIdDisponibilidadViajar(int idDisponibilidadViajar) {
		this.idDisponibilidadViajar = idDisponibilidadViajar;
	}
}
