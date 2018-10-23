/**
 * DatosHerramientasUsadasBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosHerramientasUsadasBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de Herramientas usadas
public class DatosHerramientasUsadasBean extends DatosPistaAuditoraBean {
	
	/** The idherramienta. */
	//Variable para declara los getter y setter de herramientas usadas
	@NotNull
	private int idherramienta=0;
	
	/** The porcentajeherra. */
	@NotNull
	private int porcentajeherra=0;
	
	/** The anosexpherra. */
	@NotNull
	private int anosexpherra=0;
	
	/** The descripcionherra. */
	@NotNull
	private String descripcionherra="";
	
	/** The version. */
	@NotNull
	private String version="";
	
	/** The idexplaboral. */
	@NotNull
	private long idexplaboral=0;
	
	/** The nombreherramienta. */
	@NotNull
	private String nombreherramienta="";
	
	/** The nombrecompleto. */
	@NotNull
	private String nombrecompleto="";
	
	/** The idherramienta nw. */
	@NotNull
	private int idherramientaNw=0;
	
	
	// declaraciones de setters y getters
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
	 * Gets the porcentajeherra.
	 *
	 * @return Obtienes el valor de porcentajeherra del tipo int
	 */
	
	public int getPorcentajeherra() {
		return porcentajeherra;
	}
	
	/**
	 * Sets the porcentajeherra.
	 *
	 * @param porcentajeherra the new porcentajeherra
	 */
	
	public void setPorcentajeherra(int porcentajeherra) {
		this.porcentajeherra = porcentajeherra;
	}
	
	/**
	 * Gets the anosexpherra.
	 *
	 * @return Obtienes el valor de añosexpherra del tipo int
	 */
	
	public int getAnosexpherra() {
		return anosexpherra;
	}
	
	/**
	 * Sets the anosexpherra.
	 *
	 * @param anosexpherra the new anosexpherra
	 */
	
	public void setAnosexpherra(int anosexpherra) {
		this.anosexpherra = anosexpherra;
	}
	
	/**
	 * Gets the descripcionherra.
	 *
	 * @return Obtienes el valor de descripcionherra del tipo String
	 */
	
	public String getDescripcionherra() {
		return descripcionherra;
	}
	
	/**
	 * Sets the descripcionherra.
	 *
	 * @param descripcionherra the new descripcionherra
	 */
	
	public void setDescripcionherra(String descripcionherra) {
		this.descripcionherra = descripcionherra;
	}
	
	/**
	 * Gets the version.
	 *
	 * @return Obtienes el valor de version del tipo String
	 */
	
	public String getVersion() {
		return version;
	}
	
	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * Gets the idexplaboral.
	 *
	 * @return Obtienes el valor de idexplaboral del tipo long
	 */
	
	public long getIdexplaboral() {
		return idexplaboral;
	}
	
	/**
	 * Sets the idexplaboral.
	 *
	 * @param idexplaboral the new idexplaboral
	 */
	
	public void setIdexplaboral(long idexplaboral) {
		this.idexplaboral = idexplaboral;
	}
	
	/**
	 * Gets the nombreherramienta.
	 *
	 * @return Obtienes el valor de nombreherramienta del tipo String
	 */
	
	public String getNombreherramienta() {
		return nombreherramienta;
	}
	
	/**
	 * Sets the nombreherramienta.
	 *
	 * @param nombreherramienta the new nombreherramienta
	 */
	
	public void setNombreherramienta(String nombreherramienta) {
		this.nombreherramienta = nombreherramienta;
	}
	
	/**
	 * Gets the nombrecompleto.
	 *
	 * @return Obtienes el valor de nombrecompleto del tipo String
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	
	/**
	 * Sets the nombrecompleto.
	 *
	 * @param nombrecompleto the new nombrecompleto
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	/**
	 * Gets the idherramienta nw.
	 *
	 * @return Obtienes el valor de idherramientaNw del tipo int
	 */
	
	public int getIdherramientaNw() {
		return idherramientaNw;
	}
	
	/**
	 * Sets the idherramienta nw.
	 *
	 * @param idherramientaNw the new idherramienta nw
	 */
	
	public void setIdherramientaNw(int idherramientaNw) {
		this.idherramientaNw = idherramientaNw;
	}
	
}
