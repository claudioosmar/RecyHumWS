/**
 * DatosPersonalesBean3.java -- 25/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean3
 */
public class DatosPersonalesBean3 extends DatosPersonalesBean4 {
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
	 * @return Obtienes el valor de idDisponibilidadCambio
	 */
	
	public int getIdDisponibilidadCambio() {
		return idDisponibilidadCambio;
	}
	
	/**
	 * @return Obtienes el valor de nacionalidad
	 */
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	/**
	 * @return Obtienes el valor de resumen
	 */
	
	public String getResumen() {
		return resumen;
	}
	
	/**
	 * @return Obtienes el valor de objetivoLaboral
	 */
	
	public String getObjetivoLaboral() {
		return ObjetivoLaboral;
	}
	
	/**
	 * @return Obtienes el valor de calle
	 */
	
	public String getCalle() {
		return calle;
	}
	
	/**
	 * @return Obtienes el valor de numeroExterior
	 */
	
	public String getNumeroExterior() {
		return numeroExterior;
	}
	
	/**
	 * @return Obtienes el valor de numeroInterior
	 */
	
	public String getNumeroInterior() {
		return numeroInterior;
	}
	
	/**
	 * @return Obtienes el valor de codigoPostal
	 */
	
	public int getCodigoPostal() {
		return idCodigoPostal;
	}
	
	/**
	 * @return Obtienes el valor de pais
	 */
	
	public String getPais() {
		return pais;
	}
	
	/**
	 * @return Obtienes el valor de idmunicipio
	 */
	
	public String getIdmunicipio() {
		return idmunicipio;
	}

	/*Seccion se Setters*/
	
	/**
	 * @param Agregar el valor a idDisponibilidadCambio
	 */
	
	public void setIdDisponibilidadCambio(int idDisponibilidadCambio) {
		this.idDisponibilidadCambio = idDisponibilidadCambio;
	}

	
	/**
	 * @param Agregar el valor a nacionalidad
	 */
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	
	/**
	 * @param Agregar el valor a resumen
	 */
	
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	
	/**
	 * @param Agregar el valor a objetivoLaboral
	 */
	
	public void setObjetivoLaboral(String objetivoLaboral) {
		ObjetivoLaboral = objetivoLaboral;
	}

	
	/**
	 * @param Agregar el valor a calle
	 */
	
	public void setCalle(String calle) {
		this.calle = calle;
	}

	
	/**
	 * @param Agregar el valor a numeroExterior
	 */
	
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	
	/**
	 * @param Agregar el valor a numeroInterior
	 */
	
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	
	/**
	 * @param Agregar el valor a codigoPostal
	 */
	
	public void setCodigoPostal(int codigoPostal) {
		idCodigoPostal = codigoPostal;
	}

	
	/**
	 * @param Agregar el valor a pais
	 */
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	
	/**
	 * @param Agregar el valor a idmunicipio
	 */
	
	public void setIdmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
	
}
