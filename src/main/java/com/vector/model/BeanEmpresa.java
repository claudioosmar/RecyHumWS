/**
 * 
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
@ManagedBean
public class BeanEmpresa {
	@NotNull
	private long IDEMPRESA;
	@NotNull
	private long idempresa;

	@NotNull
	private String nomempresa;
	@NotNull
	private int status;
	
	public long getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(long idempresa) {
		this.idempresa = idempresa;
	}
	public String getNomempresa() {
		return nomempresa;
	}
	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

	
}
