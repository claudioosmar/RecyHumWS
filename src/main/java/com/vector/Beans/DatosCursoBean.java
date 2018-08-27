/**
 * DatosCursoBean.java -- 25/08/2018
 */
package com.vector.Beans;

import com.sun.istack.internal.NotNull;

/**
 * @author Jair
 *
 */
public class DatosCursoBean{
	@NotNull
	private int idcurso;
	@NotNull
	private String nombrecurso;
	@NotNull
	private String institutocurso;
	@NotNull
	private String fechainicioc;
	@NotNull
	private String fechaterminoc;
	@NotNull
	private int idcertificado;
	@NotNull
	private long idestudio;
	@NotNull
	private long idpersona;
	
	
	
	/**
	 * @return Obtines el valor de idpersona
	 */
	public long getIdpersona() {
		return idpersona;
	}
	/**
	 * @param Agrega el parametro a idpersona
	 */
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @return Obtines el valor de idcurso
	 */
	public int getIdcurso() {
		return idcurso;
	}
	/**
	 * @param Agrega el parametro a idcurso
	 */
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	/**
	 * @return Obtines el valor de nombrecurso
	 */
	public String getNombrecurso() {
		return nombrecurso;
	}
	/**
	 * @param Agrega el parametro a nombrecurso
	 */
	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}
	/**
	 * @return Obtines el valor de institutocurso
	 */
	public String getInstitutocurso() {
		return institutocurso;
	}
	/**
	 * @param Agrega el parametro a institutocurso
	 */
	public void setInstitutocurso(String institutocurso) {
		this.institutocurso = institutocurso;
	}
	/**
	 * @return Obtines el valor de fechainicioc
	 */
	public String getFechainicioc() {
		return fechainicioc;
	}
	/**
	 * @param Agrega el parametro a fechainicioc
	 */
	public void setFechainicioc(String fechainicioc) {
		this.fechainicioc = fechainicioc;
	}
	/**
	 * @return Obtines el valor de fechaterminoc
	 */
	public String getFechaterminoc() {
		return fechaterminoc;
	}
	/**
	 * @param Agrega el parametro a fechaterminoc
	 */
	public void setFechaterminoc(String fechaterminoc) {
		this.fechaterminoc = fechaterminoc;
	}
	/**
	 * @return Obtines el valor de idcertificado
	 */
	public int getIdcertificado() {
		return idcertificado;
	}
	/**
	 * @param Agrega el parametro a idcertificado
	 */
	public void setIdcertificado(int idcertificado) {
		this.idcertificado = idcertificado;
	}
	/**
	 * @return Obtines el valor de idestudio
	 */
	public long getIdestudio() {
		return idestudio;
	}
	/**
	 * @param Agrega el parametro a idestudio
	 */
	public void setIdestudio(long idestudio) {
		this.idestudio = idestudio;
	}
	
	
}
