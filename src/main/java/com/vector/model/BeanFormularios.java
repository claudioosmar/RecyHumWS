package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanFormularios {
	@NotNull
	private int idformulario;
	@NotNull
	private String nomformulario;
	@NotNull
	private String url;
	@NotNull
	private char status;

	public int getIdformulario() {
		return idformulario;
	}

	public void setIdformulario(int idformulario) {
		this.idformulario = idformulario;
	}

	public String getNomformulario() {
		return nomformulario;
	}

	public void setNomformulario(String nomformulario) {
		this.nomformulario = nomformulario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
