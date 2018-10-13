/**
 * DatosCursoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosCursoBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de Cursos
public class DatosCursoBean {
	
	/** The idcurso. */
	//Variable para declara los getter y setter de certificado
	@NotNull
	private int idcurso=0;
	
	/** The nombrecurso. */
	@NotNull
	private String nombrecurso="";
	
	/** The institutocurso. */
	@NotNull
	private String institutocurso="";
	
	/** The fechainicioc. */
	@NotNull
	private String fechainicioc="";
	
	/** The fechaterminoc. */
	@NotNull
	private String fechaterminoc="";
	
	/** The idcertificado. */
	@NotNull
	private int idcertificado=0;
	
	/** The idestudio. */
	@NotNull
	private int idestudio=0;
	
	/** The idpersona. */
	@NotNull
	private long idpersona =0;
	
	/** The nombrecertificado. */
	@NotNull
	private String nombrecertificado="";
	
	
	//declaracion de getters y setters
	/**
	 * Gets the idcurso.
	 *
	 * @return Obtienes el valor de idcurso del tipo int
	 */
	
	public int getIdcurso() {
		return idcurso;
	}
	
	/**
	 * Sets the idcurso.
	 *
	 * @param idcurso the new idcurso
	 */
	
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	
	/**
	 * Gets the nombrecurso.
	 *
	 * @return Obtienes el valor de nombrecurso del tipo String
	 */
	
	public String getNombrecurso() {
		return nombrecurso;
	}
	
	/**
	 * Sets the nombrecurso.
	 *
	 * @param nombrecurso the new nombrecurso
	 */
	
	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}
	
	/**
	 * Gets the institutocurso.
	 *
	 * @return Obtienes el valor de institutocurso del tipo String
	 */
	
	public String getInstitutocurso() {
		return institutocurso;
	}
	
	/**
	 * Sets the institutocurso.
	 *
	 * @param institutocurso the new institutocurso
	 */
	
	public void setInstitutocurso(String institutocurso) {
		this.institutocurso = institutocurso;
	}
	
	/**
	 * Gets the fechainicioc.
	 *
	 * @return Obtienes el valor de fechainicioc del tipo String
	 */
	
	public String getFechainicioc() {
		return fechainicioc;
	}
	
	/**
	 * Sets the fechainicioc.
	 *
	 * @param fechainicioc the new fechainicioc
	 */
	
	public void setFechainicioc(String fechainicioc) {
		this.fechainicioc = fechainicioc;
	}
	
	/**
	 * Gets the fechaterminoc.
	 *
	 * @return Obtienes el valor de fechaterminoc del tipo String
	 */
	
	public String getFechaterminoc() {
		return fechaterminoc;
	}
	
	/**
	 * Sets the fechaterminoc.
	 *
	 * @param fechaterminoc the new fechaterminoc
	 */
	
	public void setFechaterminoc(String fechaterminoc) {
		this.fechaterminoc = fechaterminoc;
	}
	
	/**
	 * Gets the idcertificado.
	 *
	 * @return Obtienes el valor de idcertificado del tipo int
	 */
	
	public int getIdcertificado() {
		return idcertificado;
	}
	
	/**
	 * Sets the idcertificado.
	 *
	 * @param idcertificado the new idcertificado
	 */
	
	public void setIdcertificado(int idcertificado) {
		this.idcertificado = idcertificado;
	}
	
	/**
	 * Gets the idestudio.
	 *
	 * @return Obtienes el valor de idestudio del tipo int
	 */
	
	public int getIdestudio() {
		return idestudio;
	}
	
	/**
	 * Sets the idestudio.
	 *
	 * @param idestudio the new idestudio
	 */
	
	public void setIdestudio(int idestudio) {
		this.idestudio = idestudio;
	}
	
	/**
	 * Gets the idpersona.
	 *
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * Sets the idpersona.
	 *
	 * @param idpersona the new idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * Gets the nombrecertificado.
	 *
	 * @return Obtienes el valor de nombrecertificado del tipo String
	 */
	
	public String getNombrecertificado() {
		return nombrecertificado;
	}
	
	/**
	 * Sets the nombrecertificado.
	 *
	 * @param nombrecertificado the new nombrecertificado
	 */
	
	public void setNombrecertificado(String nombrecertificado) {
		this.nombrecertificado = nombrecertificado;
	}
}
