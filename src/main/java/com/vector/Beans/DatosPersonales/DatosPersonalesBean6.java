/**
 * DatosPersonalesBean6.java -- 05/09/2018
 */
package com.vector.Beans.DatosPersonales;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPersonalesBean6.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean de datos personoles 6
public class DatosPersonalesBean6 extends DatosPersonalesBean7{
	
	/** The edad. */
	/*Variables de DatosPersonales*/
	@NotNull
	private int edad=0;
	
	/** The idarea. */
	@NotNull
	private int idarea=0;
	
	/** The tipotelefono. */
	@NotNull
	private String tipotelefono="";
	
	/** The iddireccion. */
	@NotNull
	private long iddireccion=0;
	
	/** The telefonoprincipal nw. */
	@NotNull
	private String telefonoprincipalNw="";
	
	/** The telefonosecundario nw. */
	@NotNull
	private String telefonosecundarioNw="";
	
	/** The telefono emergente nw. */
	@NotNull
	private String telefonoEmergenteNw="";
	
	/** The correoprincipal nw. */
	@NotNull
	private String correoprincipalNw="";
	
	/** The corresecundario nw. */
	@NotNull
	private String corresecundarioNw="";
	
	/** The iduser. */
	@NotNull
	private long iduser=0;
	/*Seccion de getters y setters*/
	
	
	/**
	 * Gets the iduser.
	 *
	 * @return Obtienes el valor de iduser del tipo long
	 */
	
	public long getIduser() {
		return iduser;
	}



	
	/**
	 * Sets the iduser.
	 *
	 * @param iduser the new iduser
	 */
	
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}



	/**
	 * Gets the edad.
	 *
	 * @return Obtienes el valor de edad del tipo int
	 */
	
	public int getEdad() {
		return edad;
	}

	
	
	/**
	 * Gets the telefonoprincipal nw.
	 *
	 * @return Obtienes el valor de telefonoprincipalNw del tipo String
	 */
	
	public String getTelefonoprincipalNw() {
		return telefonoprincipalNw;
	}


	
	/**
	 * Gets the telefonosecundario nw.
	 *
	 * @return Obtienes el valor de telefonosecundarioNw del tipo String
	 */
	
	public String getTelefonosecundarioNw() {
		return telefonosecundarioNw;
	}


	
	/**
	 * Gets the telefono emergente nw.
	 *
	 * @return Obtienes el valor de telefonoEmergenteNw del tipo String
	 */
	
	public String getTelefonoEmergenteNw() {
		return telefonoEmergenteNw;
	}


	
	/**
	 * Gets the correoprincipal nw.
	 *
	 * @return Obtienes el valor de correoprincipalNw del tipo String
	 */
	
	public String getCorreoprincipalNw() {
		return correoprincipalNw;
	}


	
	/**
	 * Gets the corresecundario nw.
	 *
	 * @return Obtienes el valor de corresecundarioNw del tipo String
	 */
	
	public String getCorresecundarioNw() {
		return corresecundarioNw;
	}


	
	/**
	 * Sets the telefonoprincipal nw.
	 *
	 * @param telefonoprincipalNw the new telefonoprincipal nw
	 */
	
	public void setTelefonoprincipalNw(String telefonoprincipalNw) {
		this.telefonoprincipalNw = telefonoprincipalNw;
	}


	
	/**
	 * Sets the telefonosecundario nw.
	 *
	 * @param telefonosecundarioNw the new telefonosecundario nw
	 */
	
	public void setTelefonosecundarioNw(String telefonosecundarioNw) {
		this.telefonosecundarioNw = telefonosecundarioNw;
	}


	
	/**
	 * Sets the telefono emergente nw.
	 *
	 * @param telefonoEmergenteNw the new telefono emergente nw
	 */
	
	public void setTelefonoEmergenteNw(String telefonoEmergenteNw) {
		this.telefonoEmergenteNw = telefonoEmergenteNw;
	}


	
	/**
	 * Sets the correoprincipal nw.
	 *
	 * @param correoprincipalNw the new correoprincipal nw
	 */
	
	public void setCorreoprincipalNw(String correoprincipalNw) {
		this.correoprincipalNw = correoprincipalNw;
	}


	
	/**
	 * Sets the corresecundario nw.
	 *
	 * @param corresecundarioNw the new corresecundario nw
	 */
	
	public void setCorresecundarioNw(String corresecundarioNw) {
		this.corresecundarioNw = corresecundarioNw;
	}


	/**
	 * Gets the iddireccion.
	 *
	 * @return Obtienes el valor de iddireccion del tipo long
	 */
	
	public long getIddireccion() {
		return iddireccion;
	}



	
	/**
	 * Sets the iddireccion.
	 *
	 * @param iddireccion the new iddireccion
	 */
	
	public void setIddireccion(long iddireccion) {
		this.iddireccion = iddireccion;
	}



	/**
	 * Gets the tipotelefono.
	 *
	 * @return Obtienes el valor de tipotelefono del tipo String
	 */
	
	public String getTipotelefono() {
		return tipotelefono;
	}


	
	/**
	 * Sets the tipotelefono.
	 *
	 * @param tipotelefono the new tipotelefono
	 */
	
	public void setTipotelefono(String tipotelefono) {
		this.tipotelefono = tipotelefono;
	}


	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	
	public void setEdad(int edad) {
		this.edad = edad;
	}


	
	/**
	 * Gets the idarea.
	 *
	 * @return Obtienes el valor de idarea del tipo int
	 */
	
	public int getIdarea() {
		return idarea;
	}


	
	/**
	 * Sets the idarea.
	 *
	 * @param idarea the new idarea
	 */
	
	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}
	

}
