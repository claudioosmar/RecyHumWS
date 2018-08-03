package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanDirextranjeros {
	@NotNull
	private long iddirextranjero;
	@NotNull
	private long iddetpersona;
	@NotNull
	private long idpais;
	@NotNull
	private String codpost;
	@NotNull
	private String edodistrito;
	@NotNull
	private String mundelegacion;
	@NotNull
	private String locciudad;
	@NotNull
	private String colpriv;
	@NotNull
	private String calle;
	
	private String numinterior;
	
	private String numexterior;

	public long getIddirextranjero() {
		return iddirextranjero;
	}

	public void setIddirextranjero(long iddirextranjero) {
		this.iddirextranjero = iddirextranjero;
	}

	public long getIddetpersona() {
		return iddetpersona;
	}

	public void setIddetpersona(long iddetpersona) {
		this.iddetpersona = iddetpersona;
	}

	public long getIdpais() {
		return idpais;
	}

	public void setIdpais(long idpais) {
		this.idpais = idpais;
	}

	public String getCodpost() {
		return codpost;
	}

	public void setCodpost(String codpost) {
		this.codpost = codpost;
	}

	public String getEdodistrito() {
		return edodistrito;
	}

	public void setEdodistrito(String edodistrito) {
		this.edodistrito = edodistrito;
	}

	public String getMundelegacion() {
		return mundelegacion;
	}

	public void setMundelegacion(String mundelegacion) {
		this.mundelegacion = mundelegacion;
	}

	public String getLocciudad() {
		return locciudad;
	}

	public void setLocciudad(String locciudad) {
		this.locciudad = locciudad;
	}

	public String getColpriv() {
		return colpriv;
	}

	public void setColpriv(String colpriv) {
		this.colpriv = colpriv;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNuminterior() {
		return numinterior;
	}

	public void setNuminterior(String numinterior) {
		this.numinterior = numinterior;
	}

	public String getNumexterior() {
		return numexterior;
	}

	public void setNumexterior(String numexterior) {
		this.numexterior = numexterior;
	}

}
