/**
 * DatosCursoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosCursoBean
 */
//Clase Bean para los datos de Cursos
public class DatosCursoBean {
	//Variable para declara los getter y setter de certificado
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
	
	
	//declaracion de getters y setters
	/**
	 * @return Obtienes el valor de idcurso del tipo int
	 */
	
	public int getIdcurso() {
		return idcurso;
	}
	
	/**
	 * @param Agregar el valor a idcurso del tipo int
	 */
	
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	
	/**
	 * @return Obtienes el valor de nombrecurso del tipo String
	 */
	
	public String getNombrecurso() {
		return nombrecurso;
	}
	
	/**
	 * @param Agregar el valor a nombrecurso del tipo String
	 */
	
	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}
	
	/**
	 * @return Obtienes el valor de institutocurso del tipo String
	 */
	
	public String getInstitutocurso() {
		return institutocurso;
	}
	
	/**
	 * @param Agregar el valor a institutocurso del tipo String
	 */
	
	public void setInstitutocurso(String institutocurso) {
		this.institutocurso = institutocurso;
	}
	
	/**
	 * @return Obtienes el valor de fechainicioc del tipo String
	 */
	
	public String getFechainicioc() {
		return fechainicioc;
	}
	
	/**
	 * @param Agregar el valor a fechainicioc del tipo String
	 */
	
	public void setFechainicioc(String fechainicioc) {
		this.fechainicioc = fechainicioc;
	}
	
	/**
	 * @return Obtienes el valor de fechaterminoc del tipo String
	 */
	
	public String getFechaterminoc() {
		return fechaterminoc;
	}
	
	/**
	 * @param Agregar el valor a fechaterminoc del tipo String
	 */
	
	public void setFechaterminoc(String fechaterminoc) {
		this.fechaterminoc = fechaterminoc;
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
	
	/**
	 * @return Obtienes el valor de nombrecertificado del tipo String
	 */
	
	public String getNombrecertificado() {
		return nombrecertificado;
	}
	
	/**
	 * @param Agregar el valor a nombrecertificado del tipo String
	 */
	
	public void setNombrecertificado(String nombrecertificado) {
		this.nombrecertificado = nombrecertificado;
	}
}
