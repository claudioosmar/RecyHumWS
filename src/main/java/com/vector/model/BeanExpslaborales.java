/**
 * 
 */
package com.vector.model;
import javax.annotation.ManagedBean;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
/**
 * @author vectormx
 *
 */
@ManagedBean
public class BeanExpslaborales {
	@NotNull
	private long idexplaboral;
	@NotNull
	private long idmotivoter;
	@NotNull
	private long idtipocontrata;
	@NotNull
	private int idmotivotermino;
	@NotNull
	private int idempresa;
	@NotNull
	private int idtipocontrato;
	@NotNull
	@NotBlank
	private String puesto;
	@NotNull
	@NotBlank
	@Past
	private String finicial;
	@NotNull
	@NotBlank
	@Past
	private String ffinal;
	@NotBlank
	@NotNull
	private String actrealizadas;
	@NotBlank
	@NotNull
	private String logros;
	
	public long getIdexplaboral() {
		return idexplaboral;
	}
	public void setIdexplaboral(long idexplaboral) {
		this.idexplaboral = idexplaboral;
	}
	public int getIdmotivotermino() {
		return idmotivotermino;
	}
	public void setIdmotivotermino(int idmotivotermino) {
		this.idmotivotermino = idmotivotermino;
	}
	public int getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	public int getIdtipocontrato() {
		return idtipocontrato;
	}
	public void setIdtipocontrato(int idtipocontrato) {
		this.idtipocontrato = idtipocontrato;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getFinicial() {
		return finicial;
	}
	public void setFinicial(String finicial) {
		this.finicial = finicial;
	}
	public String getFfinal() {
		return ffinal;
	}
	public void setFfinal(String ffinal) {
		this.ffinal = ffinal;
	}
	public String getActrealizadas() {
		return actrealizadas;
	}
	public void setActrealizadas(String actrealizadas) {
		this.actrealizadas = actrealizadas;
	}
	public String getLogros() {
		return logros;
	}
	public void setLogros(String logros) {
		this.logros = logros;
	}
	

}
