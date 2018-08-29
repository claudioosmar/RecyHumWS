/**
 * DatosCursoBean.java -- 25/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Jair
 *
 */
public class DatosCursoBean {
	@NotNull
	private int idcurso=0;
	@NotNull
	private String nombrecurso="";
	@NotNull
	private String institutocurso="";
	@NotNull
	private String fechainicioc="";
	@NotNull
	private String fechaterminoc="";
	@NotNull
	private int idcertificado=0;
	@NotNull
	private int idestudio=0;
	@NotNull
	private long idpersona =0;
	@NotNull
	private String nombrecertificado="";
	
	
	
	
	/**
	 * @return Obtienes el valor de nombrecertificado
	 */
	
	public String getNombrecertificado() {
		return nombrecertificado;
	}
	
	/**
	 * @param Agregar el valor a nombrecertificado
	 */
	
	public void setNombrecertificado(String nombrecertificado) {
		this.nombrecertificado = nombrecertificado;
	}
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
	
}
