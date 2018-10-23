/**
 * DatosIdiomasBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosIdiomasBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de idiomas
public class DatosIdiomasBean extends DatosPistaAuditoraBean{
	
	/** The ididioma. */
	/*atributos para ingresar los datos de estudio*/
	@NotNull
	private int ididioma=0;
	
	/** The pcjescrito. */
	@NotNull
	private int pcjescrito=0;
	
	/** The pcjhablado. */
	@NotNull
	private int pcjhablado=0;
	
	/** The pcjentendido. */
	@NotNull
	private int pcjentendido=0;
	
	/** The descripciondominio. */
	@NotNull
	private String descripciondominio="";
	
	/** The idiomanativa. */
	@NotNull
	private String idiomanativa="";
	
	/** The idpersona. */
	@NotNull
	private long idpersona=0;
	
	/** The iddominio. */
	@NotNull
	private int iddominio=0;
	
	/** The nombrecompleto. */
	@NotNull
	private String nombrecompleto="";
	
	/** The nombreidioma. */
	@NotNull
	private String nombreidioma="";
	
	//declaracion de getters y setters
	/**
	 * Gets the ididioma.
	 *
	 * @return Obtienes el valor de ididioma del tipo int
	 */
	
	public int getIdidioma() {
		return ididioma;
	}
	
	/**
	 * Sets the ididioma.
	 *
	 * @param ididioma the new ididioma
	 */
	
	public void setIdidioma(int ididioma) {
		this.ididioma = ididioma;
	}
	
	/**
	 * Gets the pcjescrito.
	 *
	 * @return Obtienes el valor de pcjescrito del tipo int
	 */
	
	public int getPcjescrito() {
		return pcjescrito;
	}
	
	/**
	 * Sets the pcjescrito.
	 *
	 * @param pcjescrito the new pcjescrito
	 */
	
	public void setPcjescrito(int pcjescrito) {
		this.pcjescrito = pcjescrito;
	}
	
	/**
	 * Gets the pcjhablado.
	 *
	 * @return Obtienes el valor de pcjhablado del tipo int
	 */
	
	public int getPcjhablado() {
		return pcjhablado;
	}
	
	/**
	 * Sets the pcjhablado.
	 *
	 * @param pcjhablado the new pcjhablado
	 */
	
	public void setPcjhablado(int pcjhablado) {
		this.pcjhablado = pcjhablado;
	}
	
	/**
	 * Gets the pcjentendido.
	 *
	 * @return Obtienes el valor de pcjentendido del tipo int
	 */
	
	public int getPcjentendido() {
		return pcjentendido;
	}
	
	/**
	 * Sets the pcjentendido.
	 *
	 * @param pcjentendido the new pcjentendido
	 */
	
	public void setPcjentendido(int pcjentendido) {
		this.pcjentendido = pcjentendido;
	}
	
	/**
	 * Gets the descripciondominio.
	 *
	 * @return Obtienes el valor de descripciondominio del tipo String
	 */
	
	public String getDescripciondominio() {
		return descripciondominio;
	}
	
	/**
	 * Sets the descripciondominio.
	 *
	 * @param descripciondominio the new descripciondominio
	 */
	
	public void setDescripciondominio(String descripciondominio) {
		this.descripciondominio = descripciondominio;
	}
	
	/**
	 * Gets the idiomanativa.
	 *
	 * @return Obtienes el valor de idiomanativa del tipo String
	 */
	
	public String getIdiomanativa() {
		return idiomanativa;
	}
	
	/**
	 * Sets the idiomanativa.
	 *
	 * @param idiomanativa the new idiomanativa
	 */
	
	public void setIdiomanativa(String idiomanativa) {
		this.idiomanativa = idiomanativa;
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
	 * Gets the iddominio.
	 *
	 * @return Obtienes el valor de iddominio del tipo int
	 */
	
	public int getIddominio() {
		return iddominio;
	}
	
	/**
	 * Sets the iddominio.
	 *
	 * @param iddominio the new iddominio
	 */
	
	public void setIddominio(int iddominio) {
		this.iddominio = iddominio;
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
	 * Gets the nombreidioma.
	 *
	 * @return Obtienes el valor de nombreidioma del tipo String
	 */
	
	public String getNombreidioma() {
		return nombreidioma;
	}
	
	/**
	 * Sets the nombreidioma.
	 *
	 * @param nombreidioma the new nombreidioma
	 */
	
	public void setNombreidioma(String nombreidioma) {
		this.nombreidioma = nombreidioma;
	}

}
