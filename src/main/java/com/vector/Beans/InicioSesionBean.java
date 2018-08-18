/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *
 */
public class InicioSesionBean implements Model {
	/*Atributos del inicio de sesion*/
	@NotNull
	private long ID_User;
	@NotNull
	private String IP;
	@NotNull
	private String usuario;
	@NotNull
	private String contra;
	@NotNull
	private String Status;
	@NotNull
	private String token;
	@NotNull
	private String formulario_accion;
	@NotNull
	private String movimiento;
	@NotNull
	private int idtipouser;

	
	
	

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
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
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
	public String getFormulario_accion() {
		return formulario_accion;
	}
	public void setFormulario_accion(String formulario_accion) {
		this.formulario_accion = formulario_accion;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
}
