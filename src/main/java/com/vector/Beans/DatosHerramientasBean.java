/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosHerramientasBean extends LogBean implements Model{
	@NotNull
	private int idherramienta=0;
	@NotNull
	private int porcentajeherra=0;
	@NotNull
	private int añosexpherra=0;
	@NotNull
	private String descripcionherra="";
	@NotNull
	private String version;
	@NotNull
	//Si la ruta es 0 se envia Herramientas conocidas si es 1 se envia a herramientas utilizadas
	private int ruta=0;
	
	
	
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
