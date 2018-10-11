/**
 * DatosPersonalesBean8.java -- 08/10/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *WebServiceSGRH--com.vector.Beans.DatosPersonales--DatosPersonalesBean8
 */
public class DatosPersonalesBean8 {
	@NotNull
	private String actividades="";
	@NotNull
	private String nombrecarrera="";
	@NotNull
	private String descripcionidioma="";
	@NotNull
	private String nombregrado="";
	@NotNull
	private String nombreherramienta="";
	
	
	
	
	/**
	 * @return Obtienes el valor de nombregrado del tipo String
	 */
	
	public String getNombregrado() {
		return nombregrado;
	}



	
	/**
	 * @param Agregar el valor a nombregrado del tipo String
	 */
	
	public void setNombregrado(String nombregrado) {
		this.nombregrado = nombregrado;
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
	 * @return Obtienes el valor de grado del tipo String
	 */
	
	public String getGrado() {
		return nombregrado;
	}


	
	/**
	 * @param Agregar el valor a grado del tipo String
	 */
	
	public void setGrado(String grado) {
		this.nombregrado = grado;
	}


	/**
	 * @return Obtienes el valor de descripcionidioma del tipo String
	 */
	
	public String getDescripcionidioma() {
		return descripcionidioma;
	}

	
	/**
	 * @param Agregar el valor a descripcionidioma del tipo String
	 */
	
	public void setDescripcionidioma(String descripcionidioma) {
		this.descripcionidioma = descripcionidioma;
	}

	/**
	 * @return Obtienes el valor de actividades del tipo String
	 */
	
	public String getActividades() {
		return actividades;
	}
	
	/**
	 * @param Agregar el valor a actividades del tipo String
	 */
	
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
	
	/**
	 * @return Obtienes el valor de nombrecarrera del tipo String
	 */
	
	public String getNombrecarrera() {
		return nombrecarrera;
	}
	
	/**
	 * @param Agregar el valor a nombrecarrera del tipo String
	 */
	
	public void setNombrecarrera(String nombrecarrera) {
		this.nombrecarrera = nombrecarrera;
	}
}
