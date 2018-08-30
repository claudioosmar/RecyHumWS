/**
 * DatosLaboralesBean.java -- 30/08/2018
 */
package com.vector.Beans;

import com.sun.istack.internal.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosLaboralesBean
 */
//Clase Bean para los datos de experiencias laborales
public class DatosLaboralesBean {
	//Variable para declara los getter y setter de experiencias laborales
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
	
	// declaracion de getters y setters
	/**
	 * @return Obtienes el valor de idmotivotermino del tipo int
	 */
	
	public int getIdmotivotermino() {
		return idmotivotermino;
	}
	
	/**
	 * @param Agregar el valor a idmotivotermino del tipo int
	 */
	
	public void setIdmotivotermino(int idmotivotermino) {
		this.idmotivotermino = idmotivotermino;
	}
	
	/**
	 * @return Obtienes el valor de puesto del tipo String
	 */
	
	public String getPuesto() {
		return puesto;
	}
	
	/**
	 * @param Agregar el valor a puesto del tipo String
	 */
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	/**
	 * @return Obtienes el valor de fechainicioexp del tipo String
	 */
	
	public String getFechainicioexp() {
		return fechainicioexp;
	}
	
	/**
	 * @param Agregar el valor a fechainicioexp del tipo String
	 */
	
	public void setFechainicioexp(String fechainicioexp) {
		this.fechainicioexp = fechainicioexp;
	}
	
	/**
	 * @return Obtienes el valor de fechafinalexp del tipo String
	 */
	
	public String getFechafinalexp() {
		return fechafinalexp;
	}
	
	/**
	 * @param Agregar el valor a fechafinalexp del tipo String
	 */
	
	public void setFechafinalexp(String fechafinalexp) {
		this.fechafinalexp = fechafinalexp;
	}
	
	/**
	 * @return Obtienes el valor de actividadesreal del tipo String
	 */
	
	public String getActividadesreal() {
		return actividadesreal;
	}
	
	/**
	 * @param Agregar el valor a actividadesreal del tipo String
	 */
	
	public void setActividadesreal(String actividadesreal) {
		this.actividadesreal = actividadesreal;
	}
	
	/**
	 * @return Obtienes el valor de logros del tipo String
	 */
	
	public String getLogros() {
		return logros;
	}
	
	/**
	 * @param Agregar el valor a logros del tipo String
	 */
	
	public void setLogros(String logros) {
		this.logros = logros;
	}
	
	/**
	 * @return Obtienes el valor de idtipocontrato del tipo int
	 */
	
	public int getIdtipocontrato() {
		return idtipocontrato;
	}
	
	/**
	 * @param Agregar el valor a idtipocontrato del tipo int
	 */
	
	public void setIdtipocontrato(int idtipocontrato) {
		this.idtipocontrato = idtipocontrato;
	}
	
	/**
	 * @return Obtienes el valor de descripcionexp del tipo String
	 */
	
	public String getDescripcionexp() {
		return descripcionexp;
	}
	
	/**
	 * @param Agregar el valor a descripcionexp del tipo String
	 */
	
	public void setDescripcionexp(String descripcionexp) {
		this.descripcionexp = descripcionexp;
	}
	
	/**
	 * @return Obtienes el valor de nombreempresa del tipo String
	 */
	
	public String getNombreempresa() {
		return nombreempresa;
	}
	
	/**
	 * @param Agregar el valor a nombreempresa del tipo String
	 */
	
	public void setNombreempresa(String nombreempresa) {
		this.nombreempresa = nombreempresa;
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
	 * @return Obtienes el valor de idherramienta del tipo int
	 */
	
	public int getIdherramienta() {
		return idherramienta;
	}
	
	/**
	 * @param Agregar el valor a idherramienta del tipo int
	 */
	
	public void setIdherramienta(int idherramienta) {
		this.idherramienta = idherramienta;
	}
	
	/**
	 * @return Obtienes el valor de porsentajeherra del tipo int
	 */
	
	public int getPorsentajeherra() {
		return porsentajeherra;
	}
	
	/**
	 * @param Agregar el valor a porsentajeherra del tipo int
	 */
	
	public void setPorsentajeherra(int porsentajeherra) {
		this.porsentajeherra = porsentajeherra;
	}
	
	/**
	 * @return Obtienes el valor de añosexp del tipo int
	 */
	
	public int getAñosexp() {
		return añosexp;
	}
	
	/**
	 * @param Agregar el valor a añosexp del tipo int
	 */
	
	public void setAñosexp(int añosexp) {
		this.añosexp = añosexp;
	}
	
	/**
	 * @return Obtienes el valor de descripcionherrm del tipo String
	 */
	
	public String getDescripcionherrm() {
		return descripcionherrm;
	}
	
	/**
	 * @param Agregar el valor a descripcionherrm del tipo String
	 */
	
	public void setDescripcionherrm(String descripcionherrm) {
		this.descripcionherrm = descripcionherrm;
	}
	
	/**
	 * @return Obtienes el valor de iddescmotivo del tipo int
	 */
	
	public int getIddescmotivo() {
		return iddescmotivo;
	}
	
	/**
	 * @param Agregar el valor a iddescmotivo del tipo int
	 */
	
	public void setIddescmotivo(int iddescmotivo) {
		this.iddescmotivo = iddescmotivo;
	}
	
	/**
	 * @return Obtienes el valor de idexplaborl del tipo int
	 */
	
	public int getIdexplaborl() {
		return idexplaborl;
	}
	
	/**
	 * @param Agregar el valor a idexplaborl del tipo int
	 */
	
	public void setIdexplaborl(int idexplaborl) {
		this.idexplaborl = idexplaborl;
	}
	
	/**
	 * @return Obtienes el valor de idempresa del tipo int
	 */
	
	public int getIdempresa() {
		return idempresa;
	}
	
	/**
	 * @param Agregar el valor a idempresa del tipo int
	 */
	
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	
	
}
