/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosCertificadoBean {
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
	
	
	/**
	 * @return the iddocumentoLt
	 */
	public int getIddocumentoLt() {
		return iddocumentoLt;
	}
	/**
	 * @param iddocumentoLt the iddocumentoLt to set
	 */
	public void setIddocumentoLt(int iddocumentoLt) {
		this.iddocumentoLt = iddocumentoLt;
	}
	/**
	 * @return the idestudio
	 */
	public int getIdestudio() {
		return idestudio;
	}
	/**
	 * @param idestudio the idestudio to set
	 */
	public void setIdestudio(int idestudio) {
		this.idestudio = idestudio;
	}
	/**
	 * @return the idcertificado
	 */
	public int getIdcertificado() {
		return idcertificado;
	}
	/**
	 * @param idcertificado the idcertificado to set
	 */
	public void setIdcertificado(int idcertificado) {
		this.idcertificado = idcertificado;
	}
	/**
	 * @return the nombrecertificado
	 */
	public String getNomcertificadoNw() {
		return nomcertificadoNw;
	}
	/**
	 * @param nombrecertificado the nombrecertificado to set
	 */
	public void setNomcertificadoNw(String nomcertificado) {
		this.nomcertificadoNw = nomcertificado;
	}
	/**
	 * @return the nomcertificadoLt
	 */
	public String getNomcertificadoLt() {
		return nomcertificadoLt;
	}
	/**
	 * @param nomcertificadoLt the nomcertificadoLt to set
	 */
	public void setNomcertificadoLt(String nomcertificadoLt) {
		this.nomcertificadoLt = nomcertificadoLt;
	}
	/**
	 * @return the iddocumento
	 */
	public int getIddocumentoNw() {
		return iddocumentoNw;
	}
	/**
	 * @param iddocumento the iddocumento to set
	 */
	public void setIddocumentoNw(int iddocumento) {
		this.iddocumentoNw = iddocumento;
	}


	
	
}
