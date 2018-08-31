/**
 * DatosDocumentoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosDocumentoBean
 */
//Clase Bean para los datos de documentos
public class DatosDocumentoBean {
	//Variable para declara los getter y setter de documento
	@NotNull
	private int iddocumentoNw=0;
	@NotNull
	private String descripciondocNw="";
	@NotNull
	private String urldocNw="";
	
	private int idpersona =0;
	
	@NotNull
	private int iddocumentoLt=0;
	@NotNull
	private String descripciondocLt="";
	
	@NotNull
	private String urldocLt="";

	
	/**
	 * @return Obtienes el valor de iddocumentoNw del tipo int
	 */
	
	public int getIddocumentoNw() {
		return iddocumentoNw;
	}

	
	/**
	 * @param Agregar el valor a iddocumentoNw del tipo int
	 */
	
	public void setIddocumentoNw(int iddocumentoNw) {
		this.iddocumentoNw = iddocumentoNw;
	}

	
	/**
	 * @return Obtienes el valor de descripciondocNw del tipo String
	 */
	
	public String getDescripciondocNw() {
		return descripciondocNw;
	}

	
	/**
	 * @param Agregar el valor a descripciondocNw del tipo String
	 */
	
	public void setDescripciondocNw(String descripciondocNw) {
		this.descripciondocNw = descripciondocNw;
	}

	
	/**
	 * @return Obtienes el valor de urldocNw del tipo String
	 */
	
	public String getUrldocNw() {
		return urldocNw;
	}

	
	/**
	 * @param Agregar el valor a urldocNw del tipo String
	 */
	
	public void setUrldocNw(String urldocNw) {
		this.urldocNw = urldocNw;
	}

	
	/**
	 * @return Obtienes el valor de idpersona del tipo int
	 */
	
	public int getIdpersona() {
		return idpersona;
	}

	
	/**
	 * @param Agregar el valor a idpersona del tipo int
	 */
	
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	
	/**
	 * @return Obtienes el valor de iddocumentoLt del tipo int
	 */
	
	public int getIddocumentoLt() {
		return iddocumentoLt;
	}

	
	/**
	 * @param Agregar el valor a iddocumentoLt del tipo int
	 */
	
	public void setIddocumentoLt(int iddocumentoLt) {
		this.iddocumentoLt = iddocumentoLt;
	}

	
	/**
	 * @return Obtienes el valor de descripciondocLt del tipo String
	 */
	
	public String getDescripciondocLt() {
		return descripciondocLt;
	}

	
	/**
	 * @param Agregar el valor a descripciondocLt del tipo String
	 */
	
	public void setDescripciondocLt(String descripciondocLt) {
		this.descripciondocLt = descripciondocLt;
	}

	
	/**
	 * @return Obtienes el valor de urldocLt del tipo String
	 */
	
	public String getUrldocLt() {
		return urldocLt;
	}

	
	/**
	 * @param Agregar el valor a urldocLt del tipo String
	 */
	
	public void setUrldocLt(String urldocLt) {
		this.urldocLt = urldocLt;
	}
	
	
}
