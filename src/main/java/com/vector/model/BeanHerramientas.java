package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanHerramientas {
	@NotNull
	private long idherramientas;
	@NotNull
	private String nombreherramienta;
	@NotNull
	private String version;

	public long getIdherramientas() {
		return idherramientas;
	}

	public void setIdherramientas(long idherramientas) {
		this.idherramientas = idherramientas;
	}

	public String getNombreherramienta() {
		return nombreherramienta;
	}

	public void setNombreherramienta(String nombreherramienta) {
		this.nombreherramienta = nombreherramienta;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
