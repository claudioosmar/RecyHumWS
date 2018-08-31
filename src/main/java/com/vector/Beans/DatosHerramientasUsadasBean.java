/**
 * DatosHerramientasUsadasBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosHerramientasUsadasBean
 */
//Clase Bean para los datos de Herramientas usadas
public class DatosHerramientasUsadasBean {
	//Variable para declara los getter y setter de herramientas usadas
	@NotNull
	private int idherramienta=0;
	@NotNull
	private int porcentajeherra=0;
	@NotNull
	private int anosexpherra=0;
	@NotNull
	private String descripcionherra="";
	@NotNull
	private String version="";
	@NotNull
	private long idexplaboral=0;
	@NotNull
	private String nombreherramienta="";
	@NotNull
	private String nombrecompleto="";
	@NotNull
	private int idherramientaNw=0;
	
	
	// declaraciones de setters y getters
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
	 * @return Obtienes el valor de porcentajeherra del tipo int
	 */
	
	public int getPorcentajeherra() {
		return porcentajeherra;
	}
	
	/**
	 * @param Agregar el valor a porcentajeherra del tipo int
	 */
	
	public void setPorcentajeherra(int porcentajeherra) {
		this.porcentajeherra = porcentajeherra;
	}
	
	/**
	 * @return Obtienes el valor de añosexpherra del tipo int
	 */
	
	public int getAnosexpherra() {
		return anosexpherra;
	}
	
	/**
	 * @param Agregar el valor a añosexpherra del tipo int
	 */
	
	public void setAnosexpherra(int anosexpherra) {
		this.anosexpherra = anosexpherra;
	}
	
	/**
	 * @return Obtienes el valor de descripcionherra del tipo String
	 */
	
	public String getDescripcionherra() {
		return descripcionherra;
	}
	
	/**
	 * @param Agregar el valor a descripcionherra del tipo String
	 */
	
	public void setDescripcionherra(String descripcionherra) {
		this.descripcionherra = descripcionherra;
	}
	
	/**
	 * @return Obtienes el valor de version del tipo String
	 */
	
	public String getVersion() {
		return version;
	}
	
	/**
	 * @param Agregar el valor a version del tipo String
	 */
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * @return Obtienes el valor de idexplaboral del tipo long
	 */
	
	public long getIdexplaboral() {
		return idexplaboral;
	}
	
	/**
	 * @param Agregar el valor a idexplaboral del tipo long
	 */
	
	public void setIdexplaboral(long idexplaboral) {
		this.idexplaboral = idexplaboral;
	}
	
	/**
	 * @return Obtienes el valor de nombreherramienta del tipo String
	 */
	
	public String getNombreherramienta() {
		return nombreherramienta;
	}
	
	/**
	 * @param Agregar el valor a nombreherramienta del tipo String
	 */
	
	public void setNombreherramienta(String nombreherramienta) {
		this.nombreherramienta = nombreherramienta;
	}
	
	/**
	 * @return Obtienes el valor de nombrecompleto del tipo String
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	
	/**
	 * @param Agregar el valor a nombrecompleto del tipo String
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	/**
	 * @return Obtienes el valor de idherramientaNw del tipo int
	 */
	
	public int getIdherramientaNw() {
		return idherramientaNw;
	}
	
	/**
	 * @param Agregar el valor a idherramientaNw del tipo int
	 */
	
	public void setIdherramientaNw(int idherramientaNw) {
		this.idherramientaNw = idherramientaNw;
	}
	
}
