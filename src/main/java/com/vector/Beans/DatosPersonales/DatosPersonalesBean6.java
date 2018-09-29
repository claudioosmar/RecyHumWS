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
	@NotNull
	private String tipotelefono="";
	@NotNull
	private long iddireccion=0;
	@NotNull
	private String telefonoprincipalNw="";
	@NotNull
	private String telefonosecundarioNw="";
	@NotNull
	private String telefonoEmergenteNw="";
	@NotNull
	private String correoprincipalNw="";
	@NotNull
	private String corresecundarioNw="";
	/*Seccion de getters y setters*/
	
	/**
	 * @return Obtienes el valor de edad del tipo int
	 */
	
	public int getEdad() {
		return edad;
	}

	
	
	/**
	 * @return Obtienes el valor de telefonoprincipalNw del tipo String
	 */
	
	public String getTelefonoprincipalNw() {
		return telefonoprincipalNw;
	}


	
	/**
	 * @return Obtienes el valor de telefonosecundarioNw del tipo String
	 */
	
	public String getTelefonosecundarioNw() {
		return telefonosecundarioNw;
	}


	
	/**
	 * @return Obtienes el valor de telefonoEmergenteNw del tipo String
	 */
	
	public String getTelefonoEmergenteNw() {
		return telefonoEmergenteNw;
	}


	
	/**
	 * @return Obtienes el valor de correoprincipalNw del tipo String
	 */
	
	public String getCorreoprincipalNw() {
		return correoprincipalNw;
	}


	
	/**
	 * @return Obtienes el valor de corresecundarioNw del tipo String
	 */
	
	public String getCorresecundarioNw() {
		return corresecundarioNw;
	}


	
	/**
	 * @param Agregar el valor a telefonoprincipalNw del tipo String
	 */
	
	public void setTelefonoprincipalNw(String telefonoprincipalNw) {
		this.telefonoprincipalNw = telefonoprincipalNw;
	}


	
	/**
	 * @param Agregar el valor a telefonosecundarioNw del tipo String
	 */
	
	public void setTelefonosecundarioNw(String telefonosecundarioNw) {
		this.telefonosecundarioNw = telefonosecundarioNw;
	}


	
	/**
	 * @param Agregar el valor a telefonoEmergenteNw del tipo String
	 */
	
	public void setTelefonoEmergenteNw(String telefonoEmergenteNw) {
		this.telefonoEmergenteNw = telefonoEmergenteNw;
	}


	
	/**
	 * @param Agregar el valor a correoprincipalNw del tipo String
	 */
	
	public void setCorreoprincipalNw(String correoprincipalNw) {
		this.correoprincipalNw = correoprincipalNw;
	}


	
	/**
	 * @param Agregar el valor a corresecundarioNw del tipo String
	 */
	
	public void setCorresecundarioNw(String corresecundarioNw) {
		this.corresecundarioNw = corresecundarioNw;
	}


	/**
	 * @return Obtienes el valor de iddireccion del tipo long
	 */
	
	public long getIddireccion() {
		return iddireccion;
	}



	
	/**
	 * @param Agregar el valor a iddireccion del tipo long
	 */
	
	public void setIddireccion(long iddireccion) {
		this.iddireccion = iddireccion;
	}



	/**
	 * @return Obtienes el valor de tipotelefono del tipo String
	 */
	
	public String getTipotelefono() {
		return tipotelefono;
	}


	
	/**
	 * @param Agregar el valor a tipotelefono del tipo String
	 */
	
	public void setTipotelefono(String tipotelefono) {
		this.tipotelefono = tipotelefono;
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
