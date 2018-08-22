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
	private int idmotivotermino;
	@NotNull
	private String puesto;
	@NotNull
	private String fechainicioexp;
	@NotNull
	private String fechafinalexp;
	@NotNull
	private String actividadesreal;
	@NotNull
	private String logros;
	@NotNull
	private int idtipocontrato;
	@NotNull
	private String descripcionexp;
	@NotNull
	private String nombreempresa;
	@NotNull
	private long idpersona;
	@NotNull
	private int idherramienta;
	@NotNull
	private int porsentajeherra;
	@NotNull
	private int añosexp;
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
