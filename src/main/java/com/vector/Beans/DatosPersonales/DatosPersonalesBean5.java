/**
 * DatosPersonalesBean5.java -- 25/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean5
 */
public class DatosPersonalesBean5 {
	/*Variables de DatosPersonales*/
	@NotNull
	private String CorreoSecundario="";
	@NotNull
	private String urlComprobanteDomicilio="";
	@NotNull
	private String nombreArea="";
	@NotNull
	private String codArea="";
	@NotNull
	private String Status="";
	@NotNull 
	private int sueldo=0;
	@NotNull
	private String ncontrol="";
	@NotNull
	private String estadoCivil;
	/*Seccion de getters*/
	
	
	/**
	 * @return Obtienes el valor de nombreArea
	 */
	
	public String getNombreArea() {
		return nombreArea;
	}
	
	
	
	/**
	 * @return Obtienes el valor de estadoCivil
	 */
	
	public String getEstadoCivil() {
		return estadoCivil;
	}


	
	/**
	 * @param Agregar el valor a estadoCivil
	 */
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	/**
	 * @return Obtienes el valor de sueldo
	 */
	
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * @return Obtienes el valor de status
	 */
	
	public String getStatus() {
		return Status;
	}

	/**
	 * @return Obtienes el valor de codArea
	 */
	
	public String getCodArea() {
		return codArea;
	}
	
	/**
	 * @return Obtienes el valor de correoSecundario
	 */
	
	public String getCorreoSecundario() {
		return CorreoSecundario;
	}
	/**
	 * @return Obtienes el valor de urlComprobanteDomicilio
	 */
	
	public String getUrlComprobanteDomicilio() {
		return urlComprobanteDomicilio;
	}
	
	/*Seccion se Setters*/
	
	
	
	/**
	 * @return Obtienes el valor de ncontrol
	 */
	
	public String getNcontrol() {
		return ncontrol;
	}


	/**
	 * @param Agregar el valor a urlComprobanteDomicilio
	 */
	
	public void setUrlComprobanteDomicilio(String urlComprobanteDomicilio) {
		this.urlComprobanteDomicilio = urlComprobanteDomicilio;
	}

	/**
	 * @param Agregar el valor a correoSecundario
	 */
	
	public void setCorreoSecundario(String correoSecundario) {
		CorreoSecundario = correoSecundario;
	}
	/**
	 * @param Agregar el valor a nombreArea
	 */
	
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
	/**
	 * @param Agregar el valor a codArea
	 */
	
	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}
	
	/**
	 * @param Agregar el valor a status
	 */
	
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @param Agregar el valor a sueldo
	 */
	
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * @param Agregar el valor a ncontrol
	 */
	
	public void setNcontrol(String ncontrol) {
		this.ncontrol = ncontrol;
	}
	
}
