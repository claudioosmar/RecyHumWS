/**
 * DatosCertificadoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosCertificadoBean
 */
// CLASE QUE CONTIENE LAS VARIABLES PARA INGRESAR DATOS EN LA BASE DE DATOS
public class DatosCertificadoBean {
	//ATRIBUTOS PARA INGRESAR LOS DATOS DE CERTIFICADOS
	@NotNull
	private String nomcertificadoNw=""; 
	@NotNull
	private int iddocumentoNw=0;
	@NotNull
	private int idcertificado=0;
	@NotNull
	private String nomcertificadoLt="";
	@NotNull
	private int iddocumentoLt=0;
	@NotNull
	private int idestudio=0;
	@NotNull
	private long idpersona;
	
	
	//DECLARACIÓN DE GETTERS Y SETTERS
	/**
	 * @return Obtienes el valor de nomcertificadoNw
	 */
	
	public String getNomcertificadoNw() {
		return nomcertificadoNw;
	}
	
	/**
	 * @param Agregar el valor a nomcertificadoNw
	 */
	
	public void setNomcertificadoNw(String nomcertificadoNw) {
		this.nomcertificadoNw = nomcertificadoNw;
	}
	
	/**
	 * @return Obtienes el valor de iddocumentoNw
	 */
	
	public int getIddocumentoNw() {
		return iddocumentoNw;
	}
	
	/**
	 * @param Agregar el valor a iddocumentoNw
	 */
	
	public void setIddocumentoNw(int iddocumentoNw) {
		this.iddocumentoNw = iddocumentoNw;
	}
	
	/**
	 * @return Obtienes el valor de idcertificado
	 */
	
	public int getIdcertificado() {
		return idcertificado;
	}
	
	/**
	 * @param Agregar el valor a idcertificado
	 */
	
	public void setIdcertificado(int idcertificado) {
		this.idcertificado = idcertificado;
	}
	
	/**
	 * @return Obtienes el valor de nomcertificadoLt
	 */
	
	public String getNomcertificadoLt() {
		return nomcertificadoLt;
	}
	
	/**
	 * @param Agregar el valor a nomcertificadoLt
	 */
	
	public void setNomcertificadoLt(String nomcertificadoLt) {
		this.nomcertificadoLt = nomcertificadoLt;
	}
	
	/**
	 * @return Obtienes el valor de iddocumentoLt
	 */
	
	public int getIddocumentoLt() {
		return iddocumentoLt;
	}
	
	/**
	 * @param Agregar el valor a iddocumentoLt
	 */
	
	public void setIddocumentoLt(int iddocumentoLt) {
		this.iddocumentoLt = iddocumentoLt;
	}
	
	/**
	 * @return Obtienes el valor de idestudio
	 */
	
	public int getIdestudio() {
		return idestudio;
	}
	
	/**
	 * @param Agregar el valor a idestudio
	 */
	
	public void setIdestudio(int idestudio) {
		this.idestudio = idestudio;
	}
	
	/**
	 * @return Obtienes el valor de idpersona
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	
}
