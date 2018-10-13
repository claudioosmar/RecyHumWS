/**
 * DatosEstudioBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosEstudioBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos academicos
public class DatosEstudioBean {

/** The idgrado. */
///Variable para declara los getter y setter de estudios
	@NotNull
	private int idgrado=0;
	
	/** The idlocalidad. */
	@NotNull
	private int idlocalidad=0;
	
	/** The institutoestudio. */
	@NotNull
	private String institutoestudio="";
	
	/** The periodoinicial. */
	@NotNull
	private String periodoinicial="";
	
	/** The periodofinal. */
	@NotNull
	private String periodofinal="";
	
	/** The nombrecorrera. */
	@NotNull
	private String nombrecorrera="";
	
	/** The idpersona. */
	@NotNull
	private long idpersona=0;
	
	/** The idcarrera. */
	@NotNull
	private int idcarrera=0;
	
	/** The idestudio. */
	@NotNull
	private long idestudio=0;
	
	/** The idcertificado. */
	@NotNull
	private long idcertificado=0;
	
	/** The idcurso. */
	@NotNull
	private long idcurso=0;
	
	/** The nombrelocalidad. */
	@NotNull
	private String nombrelocalidad="";
	
	/** The nombregrado. */
	@NotNull
	private String nombregrado="";
	
	/** The nombrecompleto. */
	@NotNull
	private String nombrecompleto="";
	
	/** The nombreestado. */
	@NotNull
	private String nombreestado="";
	
	/** The nombremunicipio. */
	@NotNull
	private String nombremunicipio="";
	
	/** The idcarrera 2. */
	@NotNull
	private int idcarrera2=0;
	
	//declaracion de setters y getters
	/**
	 * Gets the idgrado.
	 *
	 * @return Obtienes el valor de idgrado del tipo int
	 */
	
	public int getIdgrado() {
		return idgrado;
	}
	
	/**
	 * Sets the idgrado.
	 *
	 * @param idgrado the new idgrado
	 */
	
	public void setIdgrado(int idgrado) {
		this.idgrado = idgrado;
	}
	
	/**
	 * Gets the idlocalidad.
	 *
	 * @return Obtienes el valor de idlocalidad del tipo int
	 */
	
	public int getIdlocalidad() {
		return idlocalidad;
	}
	
	/**
	 * Sets the idlocalidad.
	 *
	 * @param idlocalidad the new idlocalidad
	 */
	
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}
	
	/**
	 * Gets the institutoestudio.
	 *
	 * @return Obtienes el valor de institutoestudio del tipo String
	 */
	
	public String getInstitutoestudio() {
		return institutoestudio;
	}
	
	/**
	 * Sets the institutoestudio.
	 *
	 * @param institutoestudio the new institutoestudio
	 */
	
	public void setInstitutoestudio(String institutoestudio) {
		this.institutoestudio = institutoestudio;
	}
	
	/**
	 * Gets the periodoinicial.
	 *
	 * @return Obtienes el valor de periodoinicial del tipo String
	 */
	
	public String getPeriodoinicial() {
		return periodoinicial;
	}
	
	/**
	 * Sets the periodoinicial.
	 *
	 * @param periodoinicial the new periodoinicial
	 */
	
	public void setPeriodoinicial(String periodoinicial) {
		this.periodoinicial = periodoinicial;
	}
	
	/**
	 * Gets the periodofinal.
	 *
	 * @return Obtienes el valor de periodofinal del tipo String
	 */
	
	public String getPeriodofinal() {
		return periodofinal;
	}
	
	/**
	 * Sets the periodofinal.
	 *
	 * @param periodofinal the new periodofinal
	 */
	
	public void setPeriodofinal(String periodofinal) {
		this.periodofinal = periodofinal;
	}
	
	/**
	 * Gets the nombrecorrera.
	 *
	 * @return Obtienes el valor de nombrecorrera del tipo String
	 */
	
	public String getNombrecorrera() {
		return nombrecorrera;
	}
	
	/**
	 * Sets the nombrecorrera.
	 *
	 * @param nombrecorrera the new nombrecorrera
	 */
	
	public void setNombrecorrera(String nombrecorrera) {
		this.nombrecorrera = nombrecorrera;
	}
	
	/**
	 * Gets the idpersona.
	 *
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * Sets the idpersona.
	 *
	 * @param idpersona the new idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * Gets the idcarrera.
	 *
	 * @return Obtienes el valor de idcarrera del tipo int
	 */
	
	public int getIdcarrera() {
		return idcarrera;
	}
	
	/**
	 * Sets the idcarrera.
	 *
	 * @param idcarrera the new idcarrera
	 */
	
	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
	}
	
	/**
	 * Gets the idestudio.
	 *
	 * @return Obtienes el valor de idestudio del tipo long
	 */
	
	public long getIdestudio() {
		return idestudio;
	}
	
	/**
	 * Sets the idestudio.
	 *
	 * @param idestudio the new idestudio
	 */
	
	public void setIdestudio(long idestudio) {
		this.idestudio = idestudio;
	}
	
	/**
	 * Gets the idcertificado.
	 *
	 * @return Obtienes el valor de idcertificado del tipo long
	 */
	
	public long getIdcertificado() {
		return idcertificado;
	}
	
	/**
	 * Sets the idcertificado.
	 *
	 * @param idcertificado the new idcertificado
	 */
	
	public void setIdcertificado(long idcertificado) {
		this.idcertificado = idcertificado;
	}
	
	/**
	 * Gets the idcurso.
	 *
	 * @return Obtienes el valor de idcurso del tipo long
	 */
	
	public long getIdcurso() {
		return idcurso;
	}
	
	/**
	 * Sets the idcurso.
	 *
	 * @param idcurso the new idcurso
	 */
	
	public void setIdcurso(long idcurso) {
		this.idcurso = idcurso;
	}
	
	/**
	 * Gets the nombrelocalidad.
	 *
	 * @return Obtienes el valor de nombrelocalidad del tipo String
	 */
	
	public String getNombrelocalidad() {
		return nombrelocalidad;
	}
	
	/**
	 * Sets the nombrelocalidad.
	 *
	 * @param nombrelocalidad the new nombrelocalidad
	 */
	
	public void setNombrelocalidad(String nombrelocalidad) {
		this.nombrelocalidad = nombrelocalidad;
	}
	
	/**
	 * Gets the nombregrado.
	 *
	 * @return Obtienes el valor de nombregrado del tipo String
	 */
	
	public String getNombregrado() {
		return nombregrado;
	}
	
	/**
	 * Sets the nombregrado.
	 *
	 * @param nombregrado the new nombregrado
	 */
	
	public void setNombregrado(String nombregrado) {
		this.nombregrado = nombregrado;
	}
	
	/**
	 * Gets the nombrecompleto.
	 *
	 * @return Obtienes el valor de nombrecompleto del tipo String
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	
	/**
	 * Sets the nombrecompleto.
	 *
	 * @param nombrecompleto the new nombrecompleto
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	/**
	 * Gets the nombreestado.
	 *
	 * @return Obtienes el valor de nombreestado del tipo String
	 */
	
	public String getNombreestado() {
		return nombreestado;
	}
	
	/**
	 * Sets the nombreestado.
	 *
	 * @param nombreestado the new nombreestado
	 */
	
	public void setNombreestado(String nombreestado) {
		this.nombreestado = nombreestado;
	}
	
	/**
	 * Gets the nombremunicipio.
	 *
	 * @return Obtienes el valor de nombremunicipio del tipo String
	 */
	
	public String getNombremunicipio() {
		return nombremunicipio;
	}
	
	/**
	 * Sets the nombremunicipio.
	 *
	 * @param nombremunicipio the new nombremunicipio
	 */
	
	public void setNombremunicipio(String nombremunicipio) {
		this.nombremunicipio = nombremunicipio;
	}
	
	/**
	 * Gets the idcarrera 2.
	 *
	 * @return Obtienes el valor de idcarrera2 del tipo int
	 */
	
	public int getIdcarrera2() {
		return idcarrera2;
	}
	
	/**
	 * Sets the idcarrera 2.
	 *
	 * @param idcarrera2 the new idcarrera 2
	 */
	
	public void setIdcarrera2(int idcarrera2) {
		this.idcarrera2 = idcarrera2;
	}
	
	
}
