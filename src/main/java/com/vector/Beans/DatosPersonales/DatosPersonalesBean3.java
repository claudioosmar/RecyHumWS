/**
 * DatosPersonalesBean3.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean3
 */
//Clase Bean de datos personales 3 extendido de datos personales 4
public class DatosPersonalesBean3 extends DatosPersonalesBean4{
	/*Variables de DatosPersonales*/
	@NotNull
	private int idDisponibilidadCambio=0;
	@NotNull
	private String nacionalidad="";
	@NotNull
	private String resumen="";
	@NotNull
	private String ObjetivoLaboral="";
	@NotNull
	private String calle="";
	@NotNull
	private String numeroExterior="";
	@NotNull
	private String numeroInterior="";
	@NotNull
	private int idCodigoPostal=0;
	@NotNull
	private String pais="";
	@NotNull
	private String idmunicipio="";
	
	/*Seccion de getters*/
	/**
	 * @return Obtienes el valor de idDisponibilidadCambio del tipo int
	 */
	
	public int getIdDisponibilidadCambio() {
		return idDisponibilidadCambio;
	}
	
	/**
	 * @param Agregar el valor a idDisponibilidadCambio del tipo int
	 */
	
	public void setIdDisponibilidadCambio(int idDisponibilidadCambio) {
		this.idDisponibilidadCambio = idDisponibilidadCambio;
	}
	
	/**
	 * @return Obtienes el valor de nacionalidad del tipo String
	 */
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	/**
	 * @param Agregar el valor a nacionalidad del tipo String
	 */
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	/**
	 * @return Obtienes el valor de resumen del tipo String
	 */
	
	public String getResumen() {
		return resumen;
	}
	
	/**
	 * @param Agregar el valor a resumen del tipo String
	 */
	
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	/**
	 * @return Obtienes el valor de objetivoLaboral del tipo String
	 */
	
	public String getObjetivoLaboral() {
		return ObjetivoLaboral;
	}
	
	/**
	 * @param Agregar el valor a objetivoLaboral del tipo String
	 */
	
	public void setObjetivoLaboral(String objetivoLaboral) {
		ObjetivoLaboral = objetivoLaboral;
	}
	
	/**
	 * @return Obtienes el valor de calle del tipo String
	 */
	
	public String getCalle() {
		return calle;
	}
	
	/**
	 * @param Agregar el valor a calle del tipo String
	 */
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	/**
	 * @return Obtienes el valor de numeroExterior del tipo String
	 */
	
	public String getNumeroExterior() {
		return numeroExterior;
	}
	
	/**
	 * @param Agregar el valor a numeroExterior del tipo String
	 */
	
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	
	/**
	 * @return Obtienes el valor de numeroInterior del tipo String
	 */
	
	public String getNumeroInterior() {
		return numeroInterior;
	}
	
	/**
	 * @param Agregar el valor a numeroInterior del tipo String
	 */
	
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	
	/**
	 * @return Obtienes el valor de idCodigoPostal del tipo int
	 */
	
	public int getIdCodigoPostal() {
		return idCodigoPostal;
	}
	
	/**
	 * @param Agregar el valor a idCodigoPostal del tipo int
	 */
	
	public void setIdCodigoPostal(int idCodigoPostal) {
		this.idCodigoPostal = idCodigoPostal;
	}
	
	/**
	 * @return Obtienes el valor de pais del tipo String
	 */
	
	public String getPais() {
		return pais;
	}
	
	/**
	 * @param Agregar el valor a pais del tipo String
	 */
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/**
	 * @return Obtienes el valor de idmunicipio del tipo String
	 */
	
	public String getIdmunicipio() {
		return idmunicipio;
	}
	
	/**
	 * @param Agregar el valor a idmunicipio del tipo String
	 */
	
	public void setIdmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
	
}
