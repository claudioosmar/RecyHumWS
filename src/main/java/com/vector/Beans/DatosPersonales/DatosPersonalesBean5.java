/**
 * DatosPersonalesBean5.java -- 30/08/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean5
 */
//Clase Bean de datos personoles 5
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
	private String estadoCivil="";
	@NotNull
	private int codpost=0;
	@NotNull
	private int idlocalidad=0;
	/*Seccion de getters*/
	
	
	
	/**
	 * @return Obtienes el valor de correoSecundario del tipo String
	 */
	
	public String getCorreoSecundario() {
		return CorreoSecundario;
	}
	
	
	
	/**
	 * @return Obtienes el valor de idlocalidad del tipo int
	 */
	
	public int getIdlocalidad() {
		return idlocalidad;
	}


	
	/**
	 * @param Agregar el valor a idlocalidad del tipo int
	 */
	
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}


	/**
	 * @return Obtienes el valor de codpost del tipo int
	 */
	
	public int getCodpost() {
		return codpost;
	}

	
	/**
	 * @param Agregar el valor a codpost del tipo int
	 */
	
	public void setCodpost(int codpost) {
		this.codpost = codpost;
	}

	/**
	 * @param Agregar el valor a correoSecundario del tipo String
	 */
	
	public void setCorreoSecundario(String correoSecundario) {
		CorreoSecundario = correoSecundario;
	}
	
	/**
	 * @return Obtienes el valor de urlComprobanteDomicilio del tipo String
	 */
	
	public String getUrlComprobanteDomicilio() {
		return urlComprobanteDomicilio;
	}
	
	/**
	 * @param Agregar el valor a urlComprobanteDomicilio del tipo String
	 */
	
	public void setUrlComprobanteDomicilio(String urlComprobanteDomicilio) {
		this.urlComprobanteDomicilio = urlComprobanteDomicilio;
	}
	
	/**
	 * @return Obtienes el valor de nombreArea del tipo String
	 */
	
	public String getNombreArea() {
		return nombreArea;
	}
	
	/**
	 * @param Agregar el valor a nombreArea del tipo String
	 */
	
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
	/**
	 * @return Obtienes el valor de codArea del tipo String
	 */
	
	public String getCodArea() {
		return codArea;
	}
	
	/**
	 * @param Agregar el valor a codArea del tipo String
	 */
	
	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}
	
	/**
	 * @return Obtienes el valor de status del tipo String
	 */
	
	public String getStatus() {
		return Status;
	}
	
	/**
	 * @param Agregar el valor a status del tipo String
	 */
	
	public void setStatus(String status) {
		Status = status;
	}
	
	/**
	 * @return Obtienes el valor de sueldo del tipo int
	 */
	
	public int getSueldo() {
		return sueldo;
	}
	
	/**
	 * @param Agregar el valor a sueldo del tipo int
	 */
	
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	/**
	 * @return Obtienes el valor de ncontrol del tipo String
	 */
	
	public String getNcontrol() {
		return ncontrol;
	}
	
	/**
	 * @param Agregar el valor a ncontrol del tipo String
	 */
	
	public void setNcontrol(String ncontrol) {
		this.ncontrol = ncontrol;
	}
	
	/**
	 * @return Obtienes el valor de estadoCivil del tipo String
	 */
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	/**
	 * @param Agregar el valor a estadoCivil del tipo String
	 */
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}
