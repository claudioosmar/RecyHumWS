/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
/*clase publica de los beans para idiomas extendiendo de logbean*/
public class DatosIdiomasBean extends LogBean implements Model {
	/*atributos para ingresar los datos de estudio*/
	@NotNull
	private int ididioma;
	@NotNull
	private int pcjescrito;
	@NotNull
	private int pcjhablado;
	@NotNull
	private int pcjentendido;
	@NotNull
	private String descripciondominio;
	@NotNull
	private String idiomanativa;
	@NotNull
	private long idpersona;
	
	/**
	 * @return the ididioma
	 */
	public int getIdidioma() {
		return ididioma;
	}
	/**
	 * @param ididioma the ididioma to set
	 */
	public void setIdidioma(int ididioma) {
		this.ididioma = ididioma;
	}
	/**
	 * @return the pcjescrito
	 */
	public int getPcjescrito() {
		return pcjescrito;
	}
	/**
	 * @param pcjescrito the pcjescrito to set
	 */
	public void setPcjescrito(int pcjescrito) {
		this.pcjescrito = pcjescrito;
	}
	/**
	 * @return the pcjhablado
	 */
	public int getPcjhablado() {
		return pcjhablado;
	}
	/**
	 * @param pcjhablado the pcjhablado to set
	 */
	public void setPcjhablado(int pcjhablado) {
		this.pcjhablado = pcjhablado;
	}
	/**
	 * @return the pcjentendido
	 */
	public int getPcjentendido() {
		return pcjentendido;
	}
	/**
	 * @param pcjentendido the pcjentendido to set
	 */
	public void setPcjentendido(int pcjentendido) {
		this.pcjentendido = pcjentendido;
	}
	/**
	 * @return the descripciondominio
	 */
	public String getDescripciondominio() {
		return descripciondominio;
	}
	/**
	 * @param descripciondominio the descripciondominio to set
	 */
	public void setDescripciondominio(String descripciondominio) {
		this.descripciondominio = descripciondominio;
	}
	/**
	 * @return the idiomanativa
	 */
	public String getIdiomanativa() {
		return idiomanativa;
	}
	/**
	 * @param idiomanativa the idiomanativa to set
	 */
	public void setIdiomanativa(String idiomanativa) {
		this.idiomanativa = idiomanativa;
	}
	
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
}
