/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosLaboralesBean extends LogBean implements Model{
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
	private String descripcionherrm="";
	private int iddescmotivo=0;
	private int idexplaborl=0;
	private int idempresa=0;
	
	
	/**
	 * @return the descripcionherrm
	 */
	public String getDescripcionherrm() {
		return descripcionherrm;
	}
	/**
	 * @param descripcionherrm the descripcionherrm to set
	 */
	public void setDescripcionherrm(String descripcionherrm) {
		this.descripcionherrm = descripcionherrm;
	}
	/**
	 * @return the iddescmotivo
	 */
	public int getIddescmotivo() {
		return iddescmotivo;
	}
	/**
	 * @param iddescmotivo the iddescmotivo to set
	 */
	public void setIddescmotivo(int iddescmotivo) {
		this.iddescmotivo = iddescmotivo;
	}
	/**
	 * @return the idexplaborl
	 */
	public int getIdexplaborl() {
		return idexplaborl;
	}
	/**
	 * @param idexplaborl the idexplaborl to set
	 */
	public void setIdexplaborl(int idexplaborl) {
		this.idexplaborl = idexplaborl;
	}
	/**
	 * @return the idempresa
	 */
	public int getIdempresa() {
		return idempresa;
	}
	/**
	 * @param idempresa the idempresa to set
	 */
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	/**
	 * @return the idmotivotermino
	 */
	public int getIdmotivotermino() {
		return idmotivotermino;
	}
	/**
	 * @param idmotivotermino the idmotivotermino to set
	 */
	public void setIdmotivotermino(int idmotivotermino) {
		this.idmotivotermino = idmotivotermino;
	}
	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}
	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	/**
	 * @return the fechainicioexp
	 */
	public String getFechainicioexp() {
		return fechainicioexp;
	}
	/**
	 * @param fechainicioexp the fechainicioexp to set
	 */
	public void setFechainicioexp(String fechainicioexp) {
		this.fechainicioexp = fechainicioexp;
	}
	/**
	 * @return the fechafinalexp
	 */
	public String getFechafinalexp() {
		return fechafinalexp;
	}
	/**
	 * @param fechafinalexp the fechafinalexp to set
	 */
	public void setFechafinalexp(String fechafinalexp) {
		this.fechafinalexp = fechafinalexp;
	}
	/**
	 * @return the actividadesreal
	 */
	public String getActividadesreal() {
		return actividadesreal;
	}
	/**
	 * @param actividadesreal the actividadesreal to set
	 */
	public void setActividadesreal(String actividadesreal) {
		this.actividadesreal = actividadesreal;
	}
	/**
	 * @return the logros
	 */
	public String getLogros() {
		return logros;
	}
	/**
	 * @param logros the logros to set
	 */
	public void setLogros(String logros) {
		this.logros = logros;
	}
	/**
	 * @return the idtipocontrato
	 */
	public int getIdtipocontrato() {
		return idtipocontrato;
	}
	/**
	 * @param idtipocontrato the idtipocontrato to set
	 */
	public void setIdtipocontrato(int idtipocontrato) {
		this.idtipocontrato = idtipocontrato;
	}
	/**
	 * @return the descripcionexp
	 */
	public String getDescripcionexp() {
		return descripcionexp;
	}
	/**
	 * @param descripcionexp the descripcionexp to set
	 */
	public void setDescripcionexp(String descripcionexp) {
		this.descripcionexp = descripcionexp;
	}
	/**
	 * @return the nombreempresa
	 */
	public String getNombreempresa() {
		return nombreempresa;
	}
	/**
	 * @param nombreempresa the nombreempresa to set
	 */
	public void setNombreempresa(String nombreempresa) {
		this.nombreempresa = nombreempresa;
	}
	/**
	 * @return the idpersona
	 */
	public long getIdpersona() {
		return idpersona;
	}
	/**
	 * @param idpersona the idpersona to set
	 */
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @return the idherramienta
	 */
	public int getIdherramienta() {
		return idherramienta;
	}
	/**
	 * @param idherramienta the idherramienta to set
	 */
	public void setIdherramienta(int idherramienta) {
		this.idherramienta = idherramienta;
	}
	/**
	 * @return the porsentajeherra
	 */
	public int getPorsentajeherra() {
		return porsentajeherra;
	}
	/**
	 * @param porsentajeherra the porsentajeherra to set
	 */
	public void setPorsentajeherra(int porsentajeherra) {
		this.porsentajeherra = porsentajeherra;
	}
	/**
	 * @return the añosexp
	 */
	public int getAñosexp() {
		return añosexp;
	}
	/**
	 * @param añosexp the añosexp to set
	 */
	public void setAñosexp(int añosexp) {
		this.añosexp = añosexp;
	}
	
	
	
}
