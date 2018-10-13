/**
 * DatosLaboralesBean.java -- 30/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosLaboralesBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de experiencias laborales
public class DatosLaboralesBean {
	
	/** The idmotivotermino. */
	//Variable para declara los getter y setter de experiencias laborales
	@NotNull
	private int idmotivotermino=0;
	
	/** The puesto. */
	@NotNull
	private String puesto="";
	
	/** The fechainicioexp. */
	@NotNull
	private String fechainicioexp="";
	
	/** The fechafinalexp. */
	@NotNull
	private String fechafinalexp="";
	
	/** The actividadesreal. */
	@NotNull
	private String actividadesreal="";
	
	/** The logros. */
	@NotNull
	private String logros="";
	
	/** The idtipocontrato. */
	@NotNull
	private int idtipocontrato=0;
	
	/** The descripcionexp. */
	@NotNull
	private String descripcionexp="";
	
	/** The nombreempresa. */
	@NotNull
	private String nombreempresa="";
	
	/** The idpersona. */
	@NotNull
	private long idpersona=0;
	
	/** The idherramienta. */
	@NotNull
	private int idherramienta=0;
	
	/** The porsentajeherra. */
	@NotNull
	private int porsentajeherra=0;
	
	/** The añosexp. */
	@NotNull
	private int añosexp=0;
	
	/** The descripcionherrm. */
	@NotNull
	private String descripcionherrm="";
	
	/** The iddescmotivo. */
	@NotNull
	private int iddescmotivo=0;
	
	/** The idexplaborl. */
	@NotNull
	private int idexplaborl=0;
	
	/** The idempresa. */
	@NotNull
	private int idempresa=0;
	
	// declaracion de getters y setters
	/**
	 * Gets the idmotivotermino.
	 *
	 * @return Obtienes el valor de idmotivotermino del tipo int
	 */
	
	public int getIdmotivotermino() {
		return idmotivotermino;
	}
	
	/**
	 * Sets the idmotivotermino.
	 *
	 * @param idmotivotermino the new idmotivotermino
	 */
	
	public void setIdmotivotermino(int idmotivotermino) {
		this.idmotivotermino = idmotivotermino;
	}
	
	/**
	 * Gets the puesto.
	 *
	 * @return Obtienes el valor de puesto del tipo String
	 */
	
	public String getPuesto() {
		return puesto;
	}
	
	/**
	 * Sets the puesto.
	 *
	 * @param puesto the new puesto
	 */
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	/**
	 * Gets the fechainicioexp.
	 *
	 * @return Obtienes el valor de fechainicioexp del tipo String
	 */
	
	public String getFechainicioexp() {
		return fechainicioexp;
	}
	
	/**
	 * Sets the fechainicioexp.
	 *
	 * @param fechainicioexp the new fechainicioexp
	 */
	
	public void setFechainicioexp(String fechainicioexp) {
		this.fechainicioexp = fechainicioexp;
	}
	
	/**
	 * Gets the fechafinalexp.
	 *
	 * @return Obtienes el valor de fechafinalexp del tipo String
	 */
	
	public String getFechafinalexp() {
		return fechafinalexp;
	}
	
	/**
	 * Sets the fechafinalexp.
	 *
	 * @param fechafinalexp the new fechafinalexp
	 */
	
	public void setFechafinalexp(String fechafinalexp) {
		this.fechafinalexp = fechafinalexp;
	}
	
	/**
	 * Gets the actividadesreal.
	 *
	 * @return Obtienes el valor de actividadesreal del tipo String
	 */
	
	public String getActividadesreal() {
		return actividadesreal;
	}
	
	/**
	 * Sets the actividadesreal.
	 *
	 * @param actividadesreal the new actividadesreal
	 */
	
	public void setActividadesreal(String actividadesreal) {
		this.actividadesreal = actividadesreal;
	}
	
	/**
	 * Gets the logros.
	 *
	 * @return Obtienes el valor de logros del tipo String
	 */
	
	public String getLogros() {
		return logros;
	}
	
	/**
	 * Sets the logros.
	 *
	 * @param logros the new logros
	 */
	
	public void setLogros(String logros) {
		this.logros = logros;
	}
	
	/**
	 * Gets the idtipocontrato.
	 *
	 * @return Obtienes el valor de idtipocontrato del tipo int
	 */
	
	public int getIdtipocontrato() {
		return idtipocontrato;
	}
	
	/**
	 * Sets the idtipocontrato.
	 *
	 * @param idtipocontrato the new idtipocontrato
	 */
	
	public void setIdtipocontrato(int idtipocontrato) {
		this.idtipocontrato = idtipocontrato;
	}
	
	/**
	 * Gets the descripcionexp.
	 *
	 * @return Obtienes el valor de descripcionexp del tipo String
	 */
	
	public String getDescripcionexp() {
		return descripcionexp;
	}
	
	/**
	 * Sets the descripcionexp.
	 *
	 * @param descripcionexp the new descripcionexp
	 */
	
	public void setDescripcionexp(String descripcionexp) {
		this.descripcionexp = descripcionexp;
	}
	
	/**
	 * Gets the nombreempresa.
	 *
	 * @return Obtienes el valor de nombreempresa del tipo String
	 */
	
	public String getNombreempresa() {
		return nombreempresa;
	}
	
	/**
	 * Sets the nombreempresa.
	 *
	 * @param nombreempresa the new nombreempresa
	 */
	
	public void setNombreempresa(String nombreempresa) {
		this.nombreempresa = nombreempresa;
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
	 * Gets the idherramienta.
	 *
	 * @return Obtienes el valor de idherramienta del tipo int
	 */
	
	public int getIdherramienta() {
		return idherramienta;
	}
	
	/**
	 * Sets the idherramienta.
	 *
	 * @param idherramienta the new idherramienta
	 */
	
	public void setIdherramienta(int idherramienta) {
		this.idherramienta = idherramienta;
	}
	
	/**
	 * Gets the porsentajeherra.
	 *
	 * @return Obtienes el valor de porsentajeherra del tipo int
	 */
	
	public int getPorsentajeherra() {
		return porsentajeherra;
	}
	
	/**
	 * Sets the porsentajeherra.
	 *
	 * @param porsentajeherra the new porsentajeherra
	 */
	
	public void setPorsentajeherra(int porsentajeherra) {
		this.porsentajeherra = porsentajeherra;
	}
	
	/**
	 * Gets the añosexp.
	 *
	 * @return Obtienes el valor de añosexp del tipo int
	 */
	
	public int getAñosexp() {
		return añosexp;
	}
	
	/**
	 * Sets the añosexp.
	 *
	 * @param añosexp the new añosexp
	 */
	
	public void setAñosexp(int añosexp) {
		this.añosexp = añosexp;
	}
	
	/**
	 * Gets the descripcionherrm.
	 *
	 * @return Obtienes el valor de descripcionherrm del tipo String
	 */
	
	public String getDescripcionherrm() {
		return descripcionherrm;
	}
	
	/**
	 * Sets the descripcionherrm.
	 *
	 * @param descripcionherrm the new descripcionherrm
	 */
	
	public void setDescripcionherrm(String descripcionherrm) {
		this.descripcionherrm = descripcionherrm;
	}
	
	/**
	 * Gets the iddescmotivo.
	 *
	 * @return Obtienes el valor de iddescmotivo del tipo int
	 */
	
	public int getIddescmotivo() {
		return iddescmotivo;
	}
	
	/**
	 * Sets the iddescmotivo.
	 *
	 * @param iddescmotivo the new iddescmotivo
	 */
	
	public void setIddescmotivo(int iddescmotivo) {
		this.iddescmotivo = iddescmotivo;
	}
	
	/**
	 * Gets the idexplaborl.
	 *
	 * @return Obtienes el valor de idexplaborl del tipo int
	 */
	
	public int getIdexplaborl() {
		return idexplaborl;
	}
	
	/**
	 * Sets the idexplaborl.
	 *
	 * @param idexplaborl the new idexplaborl
	 */
	
	public void setIdexplaborl(int idexplaborl) {
		this.idexplaborl = idexplaborl;
	}
	
	/**
	 * Gets the idempresa.
	 *
	 * @return Obtienes el valor de idempresa del tipo int
	 */
	
	public int getIdempresa() {
		return idempresa;
	}
	
	/**
	 * Sets the idempresa.
	 *
	 * @param idempresa the new idempresa
	 */
	
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	
	
}
