/**
 * DatosPersonalesBean.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *         RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean
 */
// Clase Bean de datos personales extendiendo de datos personales bean 2
public class DatosPersonalesBean extends DatosPersonalesBean2 {
	/* Variables de DatosPersonales */
	@NotNull
	private int idpersona = 0;
	@NotNull
	private String primerNombre = "";
	@NotNull
	private String segundoNombre = "";
	@NotNull
	private String apellidPterno = "";
	@NotNull
	private String apellidMaterno = "";
	@NotNull
	private String idSexo = "";
	@NotNull
	private String fechaNacimiento = "";
	@NotNull
	private String urlFechaNacimiento = "";
	@NotNull
	private String urlFoto = "";
	@NotNull
	private String rfc = "";

	/* Seccion de getters */
	/**
	 * @return Obtienes el valor de idpersona del tipo int
	 */

	public int getIdpersona() {
		return idpersona;
	}

	/**
	 * @param Agregar
	 *            el valor a idpersona del tipo int
	 */

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	/**
	 * @return Obtienes el valor de primerNombre del tipo String
	 */

	public String getPrimerNombre() {
		return primerNombre;
	}

	/**
	 * @param Agregar
	 *            el valor a primerNombre del tipo String
	 */

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	/**
	 * @return Obtienes el valor de segundoNombre del tipo String
	 */

	public String getSegundoNombre() {
		return segundoNombre;
	}

	/**
	 * @param Agregar
	 *            el valor a segundoNombre del tipo String
	 */

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * @return Obtienes el valor de apellidPterno del tipo String
	 */

	public String getApellidPterno() {
		return apellidPterno;
	}

	/**
	 * @param Agregar
	 *            el valor a apellidPterno del tipo String
	 */

	public void setApellidPterno(String apellidPterno) {
		this.apellidPterno = apellidPterno;
	}

	/**
	 * @return Obtienes el valor de apellidMaterno del tipo String
	 */

	public String getApellidMaterno() {
		return apellidMaterno;
	}

	/**
	 * @param Agregar
	 *            el valor a apellidMaterno del tipo String
	 */

	public void setApellidMaterno(String apellidMaterno) {
		this.apellidMaterno = apellidMaterno;
	}

	/**
	 * @return Obtienes el valor de idSexo del tipo String
	 */

	public String getIdSexo() {
		return idSexo;
	}

	/**
	 * @param Agregar
	 *            el valor a idSexo del tipo String
	 */

	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}

	/**
	 * @return Obtienes el valor de fechaNacimiento del tipo String
	 */

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param Agregar
	 *            el valor a fechaNacimiento del tipo String
	 */

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return Obtienes el valor de urlFechaNacimiento del tipo String
	 */

	public String getUrlFechaNacimiento() {
		return urlFechaNacimiento;
	}

	/**
	 * @param Agregar
	 *            el valor a urlFechaNacimiento del tipo String
	 */

	public void setUrlFechaNacimiento(String urlFechaNacimiento) {
		this.urlFechaNacimiento = urlFechaNacimiento;
	}

	/**
	 * @return Obtienes el valor de urlFoto del tipo String
	 */

	public String getUrlFoto() {
		return urlFoto;
	}

	/**
	 * @param Agregar
	 *            el valor a urlFoto del tipo String
	 */

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	/**
	 * @return Obtienes el valor de rfc del tipo String
	 */

	public String getRfc() {
		return rfc;
	}

	/**
	 * @param Agregar
	 *            el valor a rfc del tipo String
	 */

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {

		return String.format("DatosPersonalesBean [IDPERSONA=" + idpersona + "],[PRIMERNOMBRE=" + primerNombre
				+ "],[SEGUNDONOMBRE=" + segundoNombre + "],[APELLIDOPATERNO=" + apellidPterno + "],[APELLIDOMATERNO="
				+ apellidMaterno + "],[SEXO=" + idSexo + "],[FECHANACIMIENTO=" + fechaNacimiento
				+ "],[URLFECHANACIMIENTO=" + urlFechaNacimiento + "],[URLFOTO=" + urlFoto + "],[RFC=" + rfc
				+ "],[URLRFC=" + getUrlRfc() + "],[CURP=" + getcURP() + "],[URLCURP=" + getUrlcURP() + "],[IDPASAPORTE=" + getIdpasaporte()
				+ "],[IDVISA=" + getIdVisa() + "],[IDESTADOCIVIL=" + getIdEdoCivil() + "],[SEGUROSOCIAL=" + getSeguroSocial()
				+ "],[URLSEGUROSOCIAL=" + getUrlSeguroSocial() + "],[IDINFONAVIT=" + getIdInfonavit()
				+ "],[IDIDSPONIVILIDADVIAJAR=" + getIdDisponibilidadViajar() + "],[IDDISPONIVILIDADCAMBIO="
				+ getIdDisponibilidadCambio() + "],[NACIONALIDAD=" + getNacionalidad() + "],[RESUMEN=" + getResumen()
				+ "],[OBJETIVOLABORAL=" + getObjetivoLaboral() + "],[CALLE=" + getCalle() + "],[NUMEROEXTERIOR=" + getNumeroExterior()
				+ "],[NUMEROINTERIOR=" + getNumeroInterior() + "],[IDCODIGOPOSTAL=" + getIdCodigoPostal()+"],[CODPOST="+getCodpost() + "],[PAIS=" + getPais()
				+ "],[IDMUNICIPIO=" + getIdmunicipio() +"],[IDLOCALIDAD="+getIdlocalidad() +"],[COLONIA=" + getColonia() + "],[IDTELEFONOPRINCIPAL="
				+ getIdTelefonoPrincipal() + "],[TELEFONOPRINCIPAL=" + getIdTelefonoPrincipal() + "],[IDTELEFONOSECUNDARIO="
				+ getIdTelefonoSecundario() + "],[TELEFONOSECUNDARIO=" + getIdTelefonoSecundario() + "],[IDTELEFONOEMERGENCIA="
				+ getIdtelefonoEmergencia() + "],[TELEFONOEMERGENCIA=" + getIdtelefonoEmergencia() + "],[IDCORREOPRINCIPAL="
				+ getIdCorreoPrincipal() + "],[CORREOPRINCIPAL=" + getCorreoPrincipal() + "],[IDCORREOSECUNDARIO="
				+ getIdCorreoSecundario() + "],[CORREOSECUNDARIO=" + getCorreoSecundario() + "],[URLCOMPROBANTE="
				+ getUrlComprobanteDomicilio() + "],[NOMBREAREA=" + getNombreArea() + "],[CODIGOAREA=" + getCodArea() + "],[STATUS="
				+ getStatus() + "],[SUELDO=" + getSueldo() + "],[NUMEROCONTROL=" + getNcontrol() + "],[ESTADOCIVIL=" + getEstadoCivil()
				+ "],[EDAD=" + getEdad() + "],[IDAREA="	+ getIdarea() + "],[TIPOTELEFONO=" + getTipotelefono() 
				+"],[TELEFONOPRINCIPALNW="+getTelefonoprincipalNw()	+"],[TELEFONOSECUNDARIONW="+getTelefonosecundarioNw()
				+"],[TELEFONOEMERGENCIANW="+getTelefonoEmergenteNw()+"],[CORREOPRINCIPALNW="+getCorreoprincipalNw()
				+"],[CORREOSECUNDARIONW="+getCorresecundarioNw()+"], [IDDIRECCION = "+getIddireccion()+"], [IDUSER ="+getIduser()+"]");
	
	
	}
}
