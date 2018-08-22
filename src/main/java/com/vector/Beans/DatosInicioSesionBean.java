/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *
 */
public class DatosInicioSesionBean extends LogBean implements Model {
	/*Atributos del inicio de sesion*/
	@NotNull
	private long ID_User;
	@NotNull
	private String IP;
	@NotNull
	private String usuario;
	@NotNull
	private String contraseña;
	@NotNull
	private String Status;
	@NotNull
	private String token;
	@NotNull
	private String movimiento;
	@NotNull
	private int idtipouser;
	@NotNull
	private long idpersonaalta;
	@NotNull
	private long idpersona;
	@NotNull
	private String observacion;

	
	
	

	/**
	 * @return the idpersonaalta
	 */
	public long getIdpersonaalta() {
		return idpersonaalta;
	}
	/**
	 * @param idpersonaalta the idpersonaalta to set
	 */
	public void setIdpersonaalta(long idpersonaalta) {
		this.idpersonaalta = idpersonaalta;
	}
	/**
	 * @return the idpersona
	 */
	public long getIdpersona() {
		return idpersona;
	}
	/**
	 * @param idpersona the idpersona to set
	 */
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getIdtipouser() {
		return idtipouser;
	}
	public void setIdtipouser(int idtipouser) {
		this.idtipouser = idtipouser;
	}
	public long getID_User() {
		return ID_User;
	}
	public void setID_User(long iD_User) {
		ID_User = iD_User;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
