/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosHerramientasBean{
	@NotNull
	private int idherramienta=0;
	@NotNull
	private int porcentajeherra=0;
	@NotNull
	private int añosexpherra=0;
	@NotNull
	private String descripcionherra=" ";
	@NotNull
	private String version="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private String nombreherramienta="";
	@NotNull
	private String nombrecompleto="";
	@NotNull
	private int idherramientaNw=0;
	
	
	/**
	 * @return the idherramientaNw
	 */
	public int getIdherramientaNw() {
		return idherramientaNw;
	}
	/**
	 * @param idherramientaNw the idherramientaNw to set
	 */
	public void setIdherramientaNw(int idherramientaNw) {
		this.idherramientaNw = idherramientaNw;
	}
	/**
	 * @return the nombrecompleto
	 */
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	/**
	 * @param nombrecompleto the nombrecompleto to set
	 */
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	/**
	 * @return the nombreherramienta
	 */
	public String getNombreherramienta() {
		return nombreherramienta;
	}
	/**
	 * @param nombreherramienta the nombreherramienta to set
	 */
	public void setNombreherramienta(String nombreherramienta) {
		this.nombreherramienta = nombreherramienta;
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @return the porcentajeherra
	 */
	public int getPorcentajeherra() {
		return porcentajeherra;
	}
	/**
	 * @param porcentajeherra the porcentajeherra to set
	 */
	public void setPorcentajeherra(int porcentajeherra) {
		this.porcentajeherra = porcentajeherra;
	}
	/**
	 * @return the añosexpherra
	 */
	public int getAñosexpherra() {
		return añosexpherra;
	}
	/**
	 * @param añosexpherra the añosexpherra to set
	 */
	public void setAñosexpherra(int añosexpherra) {
		this.añosexpherra = añosexpherra;
	}
	/**
	 * @return the descripcionherra
	 */
	public String getDescripcionherra() {
		return descripcionherra;
	}
	/**
	 * @param descripcionherra the descripcionherra to set
	 */
	public void setDescripcionherra(String descripcionherra) {
		this.descripcionherra = descripcionherra;
	}
	
}
