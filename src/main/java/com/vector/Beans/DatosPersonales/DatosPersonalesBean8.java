/**
 * DatosPersonalesBean8.java -- 08/10/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean8.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public class DatosPersonalesBean8 {
	
	/** The actividades. */
	@NotNull
	private String actividades="";
	
	/** The nombrecarrera. */
	@NotNull
	private String nombrecarrera="";
	
	/** The descripcionidioma. */
	@NotNull
	private String descripcionidioma="";
	
	/** The nombregrado. */
	@NotNull
	private String nombregrado="";
	
	/** The nombreherramienta. */
	@NotNull
	private String nombreherramienta="";
	
	
	
	
	/**
	 * Gets the nombregrado.
	 *
	 * @return Obtienes el valor de nombregrado del tipo String
	 */
	
	public String getNombregrado() {
		return nombregrado;
	}



	
	/**
	 * Sets the nombregrado.
	 *
	 * @param nombregrado the new nombregrado
	 */
	
	public void setNombregrado(String nombregrado) {
		this.nombregrado = nombregrado;
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
	 * Gets the grado.
	 *
	 * @return Obtienes el valor de grado del tipo String
	 */
	
	public String getGrado() {
		return nombregrado;
	}


	
	/**
	 * Sets the grado.
	 *
	 * @param grado the new grado
	 */
	
	public void setGrado(String grado) {
		this.nombregrado = grado;
	}


	/**
	 * Gets the descripcionidioma.
	 *
	 * @return Obtienes el valor de descripcionidioma del tipo String
	 */
	
	public String getDescripcionidioma() {
		return descripcionidioma;
	}

	
	/**
	 * Sets the descripcionidioma.
	 *
	 * @param descripcionidioma the new descripcionidioma
	 */
	
	public void setDescripcionidioma(String descripcionidioma) {
		this.descripcionidioma = descripcionidioma;
	}

	/**
	 * Gets the actividades.
	 *
	 * @return Obtienes el valor de actividades del tipo String
	 */
	
	public String getActividades() {
		return actividades;
	}
	
	/**
	 * Sets the actividades.
	 *
	 * @param actividades the new actividades
	 */
	
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
	
	/**
	 * Gets the nombrecarrera.
	 *
	 * @return Obtienes el valor de nombrecarrera del tipo String
	 */
	
	public String getNombrecarrera() {
		return nombrecarrera;
	}
	
	/**
	 * Sets the nombrecarrera.
	 *
	 * @param nombrecarrera the new nombrecarrera
	 */
	
	public void setNombrecarrera(String nombrecarrera) {
		this.nombrecarrera = nombrecarrera;
	}
}
