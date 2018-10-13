/**
 * DatosPersonalesBean5.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean5.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean de datos personoles 5
public class DatosPersonalesBean5 extends DatosPersonalesBean6{
	
	/** The Correo secundario. */
	/*Variables de DatosPersonales*/
	@NotNull
	private String CorreoSecundario="";
	
	/** The url comprobante domicilio. */
	@NotNull
	private String urlComprobanteDomicilio="";
	
	/** The nombre area. */
	@NotNull
	private String nombreArea="";
	
	/** The cod area. */
	@NotNull
	private String codArea="";
	
	/** The Status. */
	@NotNull
	private String Status="";
	
	/** The sueldo. */
	@NotNull 
	private int sueldo=0;
	
	/** The ncontrol. */
	@NotNull
	private String ncontrol="";
	
	/** The estado civil. */
	@NotNull
	private String estadoCivil="";
	
	/** The codpost. */
	@NotNull
	private int codpost=0;
	
	/** The idlocalidad. */
	@NotNull
	private int idlocalidad=0;
	/*Seccion de getters*/
	
	
	
	/**
	 * Gets the correo secundario.
	 *
	 * @return Obtienes el valor de correoSecundario del tipo String
	 */
	
	public String getCorreoSecundario() {
		return CorreoSecundario;
	}
	
	
	
	/**
	 * Gets the idlocalidad.
	 *
	 * @return Obtienes el valor de idlocalidad del tipo int
	 */
	
	public int getIdlocalidad() {
		return idlocalidad;
	}


	
	/**
	 * Sets the idlocalidad.
	 *
	 * @param idlocalidad the new idlocalidad
	 */
	
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}


	/**
	 * Gets the codpost.
	 *
	 * @return Obtienes el valor de codpost del tipo int
	 */
	
	public int getCodpost() {
		return codpost;
	}

	
	/**
	 * Sets the codpost.
	 *
	 * @param codpost the new codpost
	 */
	
	public void setCodpost(int codpost) {
		this.codpost = codpost;
	}

	/**
	 * Sets the correo secundario.
	 *
	 * @param correoSecundario the new correo secundario
	 */
	
	public void setCorreoSecundario(String correoSecundario) {
		CorreoSecundario = correoSecundario;
	}
	
	/**
	 * Gets the url comprobante domicilio.
	 *
	 * @return Obtienes el valor de urlComprobanteDomicilio del tipo String
	 */
	
	public String getUrlComprobanteDomicilio() {
		return urlComprobanteDomicilio;
	}
	
	/**
	 * Sets the url comprobante domicilio.
	 *
	 * @param urlComprobanteDomicilio the new url comprobante domicilio
	 */
	
	public void setUrlComprobanteDomicilio(String urlComprobanteDomicilio) {
		this.urlComprobanteDomicilio = urlComprobanteDomicilio;
	}
	
	/**
	 * Gets the nombre area.
	 *
	 * @return Obtienes el valor de nombreArea del tipo String
	 */
	
	public String getNombreArea() {
		return nombreArea;
	}
	
	/**
	 * Sets the nombre area.
	 *
	 * @param nombreArea the new nombre area
	 */
	
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
	/**
	 * Gets the cod area.
	 *
	 * @return Obtienes el valor de codArea del tipo String
	 */
	
	public String getCodArea() {
		return codArea;
	}
	
	/**
	 * Sets the cod area.
	 *
	 * @param codArea the new cod area
	 */
	
	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return Obtienes el valor de status del tipo String
	 */
	
	public String getStatus() {
		return Status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	
	public void setStatus(String status) {
		Status = status;
	}
	
	/**
	 * Gets the sueldo.
	 *
	 * @return Obtienes el valor de sueldo del tipo int
	 */
	
	public int getSueldo() {
		return sueldo;
	}
	
	/**
	 * Sets the sueldo.
	 *
	 * @param sueldo the new sueldo
	 */
	
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	/**
	 * Gets the ncontrol.
	 *
	 * @return Obtienes el valor de ncontrol del tipo String
	 */
	
	public String getNcontrol() {
		return ncontrol;
	}
	
	/**
	 * Sets the ncontrol.
	 *
	 * @param ncontrol the new ncontrol
	 */
	
	public void setNcontrol(String ncontrol) {
		this.ncontrol = ncontrol;
	}
	
	/**
	 * Gets the estado civil.
	 *
	 * @return Obtienes el valor de estadoCivil del tipo String
	 */
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	/**
	 * Sets the estado civil.
	 *
	 * @param estadoCivil the new estado civil
	 */
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}
