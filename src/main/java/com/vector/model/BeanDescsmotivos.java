package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanDescsmotivos {
	@NotNull
	private long iddescmotivo;
	@NotNull
	private String descripcion;

	public long getIddescmotivo() {
		return iddescmotivo;
	}

	public void setIddescmotivo(long iddescmotivo) {
		this.iddescmotivo = iddescmotivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
