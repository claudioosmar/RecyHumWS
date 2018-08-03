package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanPistaAuditoria {
	@NotNull
	private long idpista;
	@NotNull
	private long iduser;
	@NotNull
	private String fecha;
	@NotNull
	private String hora;
	@NotNull
	private String formulario;
	@NotNull
	private String sistema;
	@NotNull
	private String accion;
	@NotNull
	private String ipequipo;
	@NotNull
	private char status;

	public long getIdpista() {
		return idpista;
	}

	public void setIdpista(long idpista) {
		this.idpista = idpista;
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getIpequipo() {
		return ipequipo;
	}

	public void setIpequipo(String ipequipo) {
		this.ipequipo = ipequipo;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
