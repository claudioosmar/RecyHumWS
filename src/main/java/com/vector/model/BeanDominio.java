package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanDominio {
	@NotNull
	private long iddominio;
	@NotNull
	private char ididiomanativa;
	@NotNull
	private long ididioma;
	@NotNull
	private long idpersona;
	@NotNull
	private long pctescrito;
	@NotNull
	private long pcthablado;
	@NotNull
	private long pctentendido;

	private String descripcion;

	public long getIddominio() {
		return iddominio;
	}

	public void setIddominio(long iddominio) {
		this.iddominio = iddominio;
	}

	public char getIdidiomanativa() {
		return ididiomanativa;
	}

	public void setIdidiomanativa(char ididiomanativa) {
		this.ididiomanativa = ididiomanativa;
	}

	public long getIdidioma() {
		return ididioma;
	}

	public void setIdidioma(long ididioma) {
		this.ididioma = ididioma;
	}

	public long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}

	public long getPctescrito() {
		return pctescrito;
	}

	public void setPctescrito(long pctescrito) {
		this.pctescrito = pctescrito;
	}

	public long getPcthablado() {
		return pcthablado;
	}

	public void setPcthablado(long pcthablado) {
		this.pcthablado = pcthablado;
	}

	public long getPctentendido() {
		return pctentendido;
	}

	public void setPctentendido(long pctentendido) {
		this.pctentendido = pctentendido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
