/**
 * DatosCertificadoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosCertificadoBean
 */
// Clase Bean para los datos de certificado 
public class DatosCertificadoBean {
	//Variable para declara los getter y setter de certificado
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
	
	/**
	 * @return Obtienes el valor de nomcertificadoNw del tipo String
	 */
	
	public String getNomcertificadoNw() {
		return nomcertificadoNw;
	}
	
	/**
	 * @param Agregar el valor a nomcertificadoNw del tipo String
	 */
	
	public void setNomcertificadoNw(String nomcertificadoNw) {
		this.nomcertificadoNw = nomcertificadoNw;
	}
	
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
	 * @return Obtienes el valor de idcertificado del tipo int
	 */
	
	public int getIdcertificado() {
		return idcertificado;
	}
	
	/**
	 * @param Agregar el valor a idcertificado del tipo int
	 */
	
	public void setIdcertificado(int idcertificado) {
		this.idcertificado = idcertificado;
	}
	
	/**
	 * @return Obtienes el valor de nomcertificadoLt del tipo String
	 */
	
	public String getNomcertificadoLt() {
		return nomcertificadoLt;
	}
	
	/**
	 * @param Agregar el valor a nomcertificadoLt del tipo String
	 */
	
	public void setNomcertificadoLt(String nomcertificadoLt) {
		this.nomcertificadoLt = nomcertificadoLt;
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
	 * @return Obtienes el valor de idestudio del tipo int
	 */
	
	public int getIdestudio() {
		return idestudio;
	}
	
	/**
	 * @param Agregar el valor a idestudio del tipo int
	 */
	
	public void setIdestudio(int idestudio) {
		this.idestudio = idestudio;
	}
	
	/**
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona del tipo long
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
}
