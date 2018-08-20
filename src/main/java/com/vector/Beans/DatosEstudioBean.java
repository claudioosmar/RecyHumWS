/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosEstudioBean extends LogBean implements Model {
/*atributos para ingresar ddatos estudio*/
	
	@NotNull
	private int idgrado;
	@NotNull
	private int idlocalidad;
	@NotNull
	private String institutoestudio;
	@NotNull
	private String periodoinicial;
	@NotNull
	private String periodofinal;
	@NotNull
	private String nombrecorrera;
	@NotNull
	private long idpersona;
	
	
	/**
	 * @return the idpersona
	 */
	public long getIdpersona() {
		return idpersona;
	}
	/**
	 * @param idpersona the idpersona to set
	 */
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @return the idgrado
	 */
	public int getIdgrado() {
		return idgrado;
	}
	/**
	 * @param idgrado the idgrado to set
	 */
	public void setIdgrado(int idgrado) {
		this.idgrado = idgrado;
	}
	/**
	 * @return the idlocalidad
	 */
	public int getIdlocalidad() {
		return idlocalidad;
	}
	/**
	 * @param idlocalidad the idlocalidad to set
	 */
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}
	/**
	 * @return the institutoestudio
	 */
	public String getInstitutoestudio() {
		return institutoestudio;
	}
	/**
	 * @param institutoestudio the institutoestudio to set
	 */
	public void setInstitutoestudio(String institutoestudio) {
		this.institutoestudio = institutoestudio;
	}
	/**
	 * @return the periodoinicial
	 */
	public String getPeriodoinicial() {
		return periodoinicial;
	}
	/**
	 * @param periodoinicial the periodoinicial to set
	 */
	public void setPeriodoinicial(String periodoinicial) {
		this.periodoinicial = periodoinicial;
	}
	/**
	 * @return the periodofinal
	 */
	public String getPeriodofinal() {
		return periodofinal;
	}
	/**
	 * @param periodofinal the periodofinal to set
	 */
	public void setPeriodofinal(String periodofinal) {
		this.periodofinal = periodofinal;
	}
	/**
	 * @return the nombrecorrera
	 */
	public String getNombrecorrera() {
		return nombrecorrera;
	}
	/**
	 * @param nombrecorrera the nombrecorrera to set
	 */
	public void setNombrecorrera(String nombrecorrera) {
		this.nombrecorrera = nombrecorrera;
	}
	
}
