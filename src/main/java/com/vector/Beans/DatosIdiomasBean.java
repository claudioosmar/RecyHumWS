/**
 * DatosIdiomasBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosIdiomasBean
 */
//Clase Bean para los datos de idiomas
public class DatosIdiomasBean {
	/*atributos para ingresar los datos de estudio*/
	@NotNull
	private int ididioma=0;
	@NotNull
	private int pcjescrito=0;
	@NotNull
	private int pcjhablado=0;
	@NotNull
	private int pcjentendido=0;
	@NotNull
	private String descripciondominio="";
	@NotNull
	private String idiomanativa="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private int iddominio=0;
	@NotNull
	private String nombrecompleto="";
	@NotNull
	private String nombreidioma="";
	
	//declaracion de getters y setters
	/**
	 * @return Obtienes el valor de ididioma del tipo int
	 */
	
	public int getIdidioma() {
		return ididioma;
	}
	
	/**
	 * @param Agregar el valor a ididioma del tipo int
	 */
	
	public void setIdidioma(int ididioma) {
		this.ididioma = ididioma;
	}
	
	/**
	 * @return Obtienes el valor de pcjescrito del tipo int
	 */
	
	public int getPcjescrito() {
		return pcjescrito;
	}
	
	/**
	 * @param Agregar el valor a pcjescrito del tipo int
	 */
	
	public void setPcjescrito(int pcjescrito) {
		this.pcjescrito = pcjescrito;
	}
	
	/**
	 * @return Obtienes el valor de pcjhablado del tipo int
	 */
	
	public int getPcjhablado() {
		return pcjhablado;
	}
	
	/**
	 * @param Agregar el valor a pcjhablado del tipo int
	 */
	
	public void setPcjhablado(int pcjhablado) {
		this.pcjhablado = pcjhablado;
	}
	
	/**
	 * @return Obtienes el valor de pcjentendido del tipo int
	 */
	
	public int getPcjentendido() {
		return pcjentendido;
	}
	
	/**
	 * @param Agregar el valor a pcjentendido del tipo int
	 */
	
	public void setPcjentendido(int pcjentendido) {
		this.pcjentendido = pcjentendido;
	}
	
	/**
	 * @return Obtienes el valor de descripciondominio del tipo String
	 */
	
	public String getDescripciondominio() {
		return descripciondominio;
	}
	
	/**
	 * @param Agregar el valor a descripciondominio del tipo String
	 */
	
	public void setDescripciondominio(String descripciondominio) {
		this.descripciondominio = descripciondominio;
	}
	
	/**
	 * @return Obtienes el valor de idiomanativa del tipo String
	 */
	
	public String getIdiomanativa() {
		return idiomanativa;
	}
	
	/**
	 * @param Agregar el valor a idiomanativa del tipo String
	 */
	
	public void setIdiomanativa(String idiomanativa) {
		this.idiomanativa = idiomanativa;
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
	 * @return Obtienes el valor de iddominio del tipo int
	 */
	
	public int getIddominio() {
		return iddominio;
	}
	
	/**
	 * @param Agregar el valor a iddominio del tipo int
	 */
	
	public void setIddominio(int iddominio) {
		this.iddominio = iddominio;
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
	 * @return Obtienes el valor de nombreidioma del tipo String
	 */
	
	public String getNombreidioma() {
		return nombreidioma;
	}
	
	/**
	 * @param Agregar el valor a nombreidioma del tipo String
	 */
	
	public void setNombreidioma(String nombreidioma) {
		this.nombreidioma = nombreidioma;
	}

}
