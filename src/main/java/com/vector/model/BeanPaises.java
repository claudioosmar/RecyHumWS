package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanPaises {
	@NotNull
	private int idpais;
	@NotNull
	private String nombrepais;
	@NotNull
	private String abreviatura;

	public int getIdpais() {
		return idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	public String getNombrepais() {
		return nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

}
