/**
 * DatosPersonalesBean.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
// Clase Bean de datos personales extendiendo de datos personales bean 2
public class DatosPersonalesBean extends DatosPersonalesBean2 {
	
	/** The idpersona. */
	/* Variables de DatosPersonales */
	@NotNull
	private int idpersona = 0;
	
	/** The primer nombre. */
	@NotNull
	private String primerNombre = "";
	
	/** The segundo nombre. */
	@NotNull
	private String segundoNombre = "";
	
	/** The apellid pterno. */
	@NotNull
	private String apellidPterno = "";
	
	/** The apellid materno. */
	@NotNull
	private String apellidMaterno = "";
	
	/** The id sexo. */
	@NotNull
	private String idSexo = "";
	
	/** The fecha nacimiento. */
	@NotNull
	private String fechaNacimiento = "";
	
	/** The url fecha nacimiento. */
	@NotNull
	private String urlFechaNacimiento = "";
	
	/** The url foto. */
	@NotNull
	private String urlFoto = "";
	
	/** The rfc. */
	@NotNull
	private String rfc = "";

	/* Seccion de getters */
	/**
	 * Gets the idpersona.
	 *
	 * @return Obtienes el valor de idpersona del tipo int
	 */

	public int getIdpersona() {
		return idpersona;
	}

	/**
	 * Sets the idpersona.
	 *
	 * @param idpersona the new idpersona
	 */

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	/**
	 * Gets the primer nombre.
	 *
	 * @return Obtienes el valor de primerNombre del tipo String
	 */

	public String getPrimerNombre() {
		return primerNombre;
	}

	/**
	 * Sets the primer nombre.
	 *
	 * @param primerNombre the new primer nombre
	 */

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	/**
	 * Gets the segundo nombre.
	 *
	 * @return Obtienes el valor de segundoNombre del tipo String
	 */

	public String getSegundoNombre() {
		return segundoNombre;
	}

	/**
	 * Sets the segundo nombre.
	 *
	 * @param segundoNombre the new segundo nombre
	 */

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * Gets the apellid pterno.
	 *
	 * @return Obtienes el valor de apellidPterno del tipo String
	 */

	public String getApellidPterno() {
		return apellidPterno;
	}

	/**
	 * Sets the apellid pterno.
	 *
	 * @param apellidPterno the new apellid pterno
	 */

	public void setApellidPterno(String apellidPterno) {
		this.apellidPterno = apellidPterno;
	}

	/**
	 * Gets the apellid materno.
	 *
	 * @return Obtienes el valor de apellidMaterno del tipo String
	 */

	public String getApellidMaterno() {
		return apellidMaterno;
	}

	/**
	 * Sets the apellid materno.
	 *
	 * @param apellidMaterno the new apellid materno
	 */

	public void setApellidMaterno(String apellidMaterno) {
		this.apellidMaterno = apellidMaterno;
	}

	/**
	 * Gets the id sexo.
	 *
	 * @return Obtienes el valor de idSexo del tipo String
	 */

	public String getIdSexo() {
		return idSexo;
	}

	/**
	 * Sets the id sexo.
	 *
	 * @param idSexo the new id sexo
	 */

	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return Obtienes el valor de fechaNacimiento del tipo String
	 */

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Gets the url fecha nacimiento.
	 *
	 * @return Obtienes el valor de urlFechaNacimiento del tipo String
	 */

	public String getUrlFechaNacimiento() {
		return urlFechaNacimiento;
	}

	/**
	 * Sets the url fecha nacimiento.
	 *
	 * @param urlFechaNacimiento the new url fecha nacimiento
	 */

	public void setUrlFechaNacimiento(String urlFechaNacimiento) {
		this.urlFechaNacimiento = urlFechaNacimiento;
	}

	/**
	 * Gets the url foto.
	 *
	 * @return Obtienes el valor de urlFoto del tipo String
	 */

	public String getUrlFoto() {
		return urlFoto;
	}

	/**
	 * Sets the url foto.
	 *
	 * @param urlFoto the new url foto
	 */

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	/**
	 * Gets the rfc.
	 *
	 * @return Obtienes el valor de rfc del tipo String
	 */

	public String getRfc() {
		return rfc;
	}

	/**
	 * Sets the rfc.
	 *
	 * @param rfc the new rfc
	 */

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/** 
	 * {@inheritDoc}
	 */
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
