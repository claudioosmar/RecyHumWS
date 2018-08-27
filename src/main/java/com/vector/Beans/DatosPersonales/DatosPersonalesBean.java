/**
 * DatosPersonalesBean.java -- 25/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean
 */
public class DatosPersonalesBean extends DatosPersonalesBean2 {
	/*Variables de DatosPersonales*/
	@NotNull
	private int idpersona=0;
	@NotNull
	private String primerNombre="";
	@NotNull
	private String segundoNombre="";
	@NotNull
	private String apellidPterno="";
	@NotNull
	private String apellidMaterno="";
	@NotNull
	private String idSexo="";
	@NotNull
	private String fechaNacimiento="";
	@NotNull
	private String urlFechaNacimiento="";
	@NotNull
	private String urlFoto="";
	@NotNull
	private String rfc="";
	
	/*Seccion de getters*/
	/**
	 * @return Obtienes el valor de idpersona
	 */
	public int getIdpersona() {
		return idpersona;
	}
	/**
	 * @return Obtienes el valor de primerNombre
	 */
	public String getPrimerNombre() {
		return primerNombre;
	}
	/**
	 * @return Obtienes el valor de segundoNombre
	 */
	public String getSegundoNombre() {
		return segundoNombre;
	}
	/**
	 * @return Obtienes el valor de apellidPterno
	 */
	public String getApellidPterno() {
		return apellidPterno;
	}
	/**
	 * @return Obtienes el valor de apellidMaterno
	 */
	public String getApellidMaterno() {
		return apellidMaterno;
	}
	/**
	 * @return Obtienes el valor de idSexo
	 */
	public String getIdSexo() {
		return idSexo;
	}
	/**
	 * @return Obtienes el valor de fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @return Obtienes el valor de urlFechaNacimiento
	 */
	public String getUrlFechaNacimiento() {
		return urlFechaNacimiento;
	}
	/**
	 * @return Obtienes el valor de urlFoto
	 */
	public String getUrlFoto() {
		return urlFoto;
	}
	/**
	 * @return Obtienes el valor de rfc
	 */
	public String getRfc() {
		return rfc;
	}
	
	
	/*Seccion se Setters*/
	
	
	/**
	 * @param Agregar el valor a idpersona
	 */
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @param Agregar el valor a primerNombre
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	/**
	 * @param Agregar el valor a segundoNombre
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	/**
	 * @param Agregar el valor a apellidPterno
	 */
	public void setApellidPterno(String apellidPterno) {
		this.apellidPterno = apellidPterno;
	}
	/**
	 * @param Agregar el valor a apellidMaterno
	 */
	public void setApellidMaterno(String apellidMaterno) {
		this.apellidMaterno = apellidMaterno;
	}
	/**
	 * @param Agregar el valor a idSexo
	 */
	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}
	/**
	 * @param Agregar el valor a fechaNacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @param Agregar el valor a urlFechaNacimiento
	 */
	public void setUrlFechaNacimiento(String urlFechaNacimiento) {
		this.urlFechaNacimiento = urlFechaNacimiento;
	}
	/**
	 * @param Agregar el valor a urlFoto
	 */
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	/**
	 * @param Agregar el valor a rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	
}
