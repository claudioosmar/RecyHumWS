package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanCertficado {
	@NotNull
	private long idcertificado;
	@NotNull
	private long iddoc;
	@NotNull
	private String nomcertificado;

	public long getIdcertificado() {
		return idcertificado;
	}

	public void setIdcertificado(long idcertificado) {
		this.idcertificado = idcertificado;
	}

	public long getIddoc() {
		return iddoc;
	}

	public void setIddoc(long iddoc) {
		this.iddoc = iddoc;
	}

	public String getNomcertificado() {
		return nomcertificado;
	}

	public void setNomcertificado(String nomcertificado) {
		this.nomcertificado = nomcertificado;
	}
}
