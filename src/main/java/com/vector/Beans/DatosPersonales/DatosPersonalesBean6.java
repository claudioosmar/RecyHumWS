/**
 * DatosPersonalesBean6.java -- 05/09/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans.DatosPersonales--DatosPersonalesBean6
 */
//Clase Bean de datos personoles 6
public class DatosPersonalesBean6 {
	/*Variables de DatosPersonales*/
	@NotNull
	private int edad=0;
	@NotNull
	private int idarea=0;

	/*Seccion de getters y setters*/
	/**
	 * @return Obtienes el valor de edad del tipo int
	 */
	
	public int getEdad() {
		return edad;
	}

	
	/**
	 * @param Agregar el valor a edad del tipo int
	 */
	
	public void setEdad(int edad) {
		this.edad = edad;
	}


	
	/**
	 * @return Obtienes el valor de idarea del tipo int
	 */
	
	public int getIdarea() {
		return idarea;
	}


	
	/**
	 * @param Agregar el valor a idarea del tipo int
	 */
	
	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}
	
	
}
