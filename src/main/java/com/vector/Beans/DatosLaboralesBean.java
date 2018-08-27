/**
 * DatosLaboralesBean.java -- 25/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosLaborales--DatosLaboralesBean
 */
public class DatosLaboralesBean {
	/*Atributos de Experiencias Laborales*/
	@NotNull
	private int idmotivotermino=0;
	@NotNull
	private String puesto="";
	@NotNull
	private String fechainicioexp="";
	@NotNull
	private String fechafinalexp="";
	@NotNull
	private String actividadesreal="";
	@NotNull
	private String logros="";
	@NotNull
	private int idtipocontrato=0;
	@NotNull
	private String descripcionexp="";
	@NotNull
	private String nombreempresa="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private int idherramienta=0;
	@NotNull
	private int porsentajeherra=0;
	@NotNull
	private int añosexp=0;
	@NotNull
	private String descripcionherrm="";
	@NotNull
	private int iddescmotivo=0;
	@NotNull
	private int idexplaborl=0;
	@NotNull
	private int idempresa=0;
	
	//Seccion de Getters
	/**
	 * @return Obtienes el valor de idmotivotermino
	 */
	public int getIdmotivotermino() {
		return idmotivotermino;
	}
	/**
	 * @return Obtienes el valor de puesto
	 */
	public String getPuesto() {
		return puesto;
	}
	/**
	 * @return Obtienes el valor de fechainicioexp
	 */
	public String getFechainicioexp() {
		return fechainicioexp;
	}
	/**
	 * @return Obtienes el valor de fechafinalexp
	 */
	public String getFechafinalexp() {
		return fechafinalexp;
	}
	/**
	 * @return Obtienes el valor de actividadesreal
	 */
	public String getActividadesreal() {
		return actividadesreal;
	}
	/**
	 * @return Obtienes el valor de logros
	 */
	public String getLogros() {
		return logros;
	}
	/**
	 * @return Obtienes el valor de idtipocontrato
	 */
	public int getIdtipocontrato() {
		return idtipocontrato;
	}
	/**
	 * @return Obtienes el valor de descripcionexp
	 */
	public String getDescripcionexp() {
		return descripcionexp;
	}
	/**
	 * @return Obtienes el valor de nombreempresa
	 */
	public String getNombreempresa() {
		return nombreempresa;
	}
	/**
	 * @return Obtienes el valor de idpersona
	 */
	public long getIdpersona() {
		return idpersona;
	}
	/**
	 * @return Obtienes el valor de idherramienta
	 */
	public int getIdherramienta() {
		return idherramienta;
	}
	/**
	 * @return Obtienes el valor de porsentajeherra
	 */
	public int getPorsentajeherra() {
		return porsentajeherra;
	}
	/**
	 * @return Obtienes el valor de añosexp
	 */
	public int getAñosexp() {
		return añosexp;
	}
	/**
	 * @return Obtienes el valor de descripcionherrm
	 */
	public String getDescripcionherrm() {
		return descripcionherrm;
	}
	/**
	 * @return Obtienes el valor de iddescmotivo
	 */
	public int getIddescmotivo() {
		return iddescmotivo;
	}
	/**
	 * @return Obtienes el valor de idexplaborl
	 */
	public int getIdexplaborl() {
		return idexplaborl;
	}
	/**
	 * @return Obtienes el valor de idempresa
	 */
	public int getIdempresa() {
		return idempresa;
	}
	
	
	//Seccion de Setters
	/**
	 * @param Agregar el valor a idmotivotermino
	 */
	public void setIdmotivotermino(int idmotivotermino) {
		this.idmotivotermino = idmotivotermino;
	}
	/**
	 * @param Agregar el valor a puesto
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	/**
	 * @param Agregar el valor a fechainicioexp
	 */
	public void setFechainicioexp(String fechainicioexp) {
		this.fechainicioexp = fechainicioexp;
	}
	/**
	 * @param Agregar el valor a fechafinalexp
	 */
	public void setFechafinalexp(String fechafinalexp) {
		this.fechafinalexp = fechafinalexp;
	}
	/**
	 * @param Agregar el valor a actividadesreal
	 */
	public void setActividadesreal(String actividadesreal) {
		this.actividadesreal = actividadesreal;
	}
	/**
	 * @param Agregar el valor a logros
	 */
	public void setLogros(String logros) {
		this.logros = logros;
	}
	/**
	 * @param Agregar el valor a idtipocontrato
	 */
	public void setIdtipocontrato(int idtipocontrato) {
		this.idtipocontrato = idtipocontrato;
	}
	/**
	 * @param Agregar el valor a descripcionexp
	 */
	public void setDescripcionexp(String descripcionexp) {
		this.descripcionexp = descripcionexp;
	}
	/**
	 * @param Agregar el valor a nombreempresa
	 */
	public void setNombreempresa(String nombreempresa) {
		this.nombreempresa = nombreempresa;
	}
	/**
	 * @param Agregar el valor a idpersona
	 */
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @param Agregar el valor a idherramienta
	 */
	public void setIdherramienta(int idherramienta) {
		this.idherramienta = idherramienta;
	}
	/**
	 * @param Agregar el valor a porsentajeherra
	 */
	public void setPorsentajeherra(int porsentajeherra) {
		this.porsentajeherra = porsentajeherra;
	}
	/**
	 * @param Agregar el valor a añosexp
	 */
	public void setAñosexp(int añosexp) {
		this.añosexp = añosexp;
	}
	/**
	 * @param Agregar el valor a descripcionherrm
	 */
	public void setDescripcionherrm(String descripcionherrm) {
		this.descripcionherrm = descripcionherrm;
	}
	/**
	 * @param Agregar el valor a iddescmotivo
	 */
	public void setIddescmotivo(int iddescmotivo) {
		this.iddescmotivo = iddescmotivo;
	}
	/**
	 * @param Agregar el valor a idexplaborl
	 */
	public void setIdexplaborl(int idexplaborl) {
		this.idexplaborl = idexplaborl;
	}
	/**
	 * @param Agregar el valor a idempresa
	 */
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	
	
}
