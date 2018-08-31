/**
 * DatosEstudioBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosEstudioBean
 */
//Clase Bean para los datos academicos
public class DatosEstudioBean {
///Variable para declara los getter y setter de estudios
	@NotNull
	private int idgrado=0;
	@NotNull
	private int idlocalidad=0;
	@NotNull
	private String institutoestudio="";
	@NotNull
	private String periodoinicial="";
	@NotNull
	private String periodofinal="";
	@NotNull
	private String nombrecorrera="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private int idcarrera=0;
	@NotNull
	private long idestudio=0;
	@NotNull
	private long idcertificado=0;
	@NotNull
	private long idcurso=0;
	@NotNull
	private String nombrelocalidad="";
	@NotNull
	private String nombregrado="";
	@NotNull
	private String nombrecompleto="";
	@NotNull
	private String nombreestado="";
	@NotNull
	private String nombremunicipio="";
	@NotNull
	private int idcarrera2=0;
	
	//declaracion de setters y getters
	/**
	 * @return Obtienes el valor de idgrado del tipo int
	 */
	
	public int getIdgrado() {
		return idgrado;
	}
	
	/**
	 * @param Agregar el valor a idgrado del tipo int
	 */
	
	public void setIdgrado(int idgrado) {
		this.idgrado = idgrado;
	}
	
	/**
	 * @return Obtienes el valor de idlocalidad del tipo int
	 */
	
	public int getIdlocalidad() {
		return idlocalidad;
	}
	
	/**
	 * @param Agregar el valor a idlocalidad del tipo int
	 */
	
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}
	
	/**
	 * @return Obtienes el valor de institutoestudio del tipo String
	 */
	
	public String getInstitutoestudio() {
		return institutoestudio;
	}
	
	/**
	 * @param Agregar el valor a institutoestudio del tipo String
	 */
	
	public void setInstitutoestudio(String institutoestudio) {
		this.institutoestudio = institutoestudio;
	}
	
	/**
	 * @return Obtienes el valor de periodoinicial del tipo String
	 */
	
	public String getPeriodoinicial() {
		return periodoinicial;
	}
	
	/**
	 * @param Agregar el valor a periodoinicial del tipo String
	 */
	
	public void setPeriodoinicial(String periodoinicial) {
		this.periodoinicial = periodoinicial;
	}
	
	/**
	 * @return Obtienes el valor de periodofinal del tipo String
	 */
	
	public String getPeriodofinal() {
		return periodofinal;
	}
	
	/**
	 * @param Agregar el valor a periodofinal del tipo String
	 */
	
	public void setPeriodofinal(String periodofinal) {
		this.periodofinal = periodofinal;
	}
	
	/**
	 * @return Obtienes el valor de nombrecorrera del tipo String
	 */
	
	public String getNombrecorrera() {
		return nombrecorrera;
	}
	
	/**
	 * @param Agregar el valor a nombrecorrera del tipo String
	 */
	
	public void setNombrecorrera(String nombrecorrera) {
		this.nombrecorrera = nombrecorrera;
	}
	
	/**
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona del tipo long
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * @return Obtienes el valor de idcarrera del tipo int
	 */
	
	public int getIdcarrera() {
		return idcarrera;
	}
	
	/**
	 * @param Agregar el valor a idcarrera del tipo int
	 */
	
	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
	}
	
	/**
	 * @return Obtienes el valor de idestudio del tipo long
	 */
	
	public long getIdestudio() {
		return idestudio;
	}
	
	/**
	 * @param Agregar el valor a idestudio del tipo long
	 */
	
	public void setIdestudio(long idestudio) {
		this.idestudio = idestudio;
	}
	
	/**
	 * @return Obtienes el valor de idcertificado del tipo long
	 */
	
	public long getIdcertificado() {
		return idcertificado;
	}
	
	/**
	 * @param Agregar el valor a idcertificado del tipo long
	 */
	
	public void setIdcertificado(long idcertificado) {
		this.idcertificado = idcertificado;
	}
	
	/**
	 * @return Obtienes el valor de idcurso del tipo long
	 */
	
	public long getIdcurso() {
		return idcurso;
	}
	
	/**
	 * @param Agregar el valor a idcurso del tipo long
	 */
	
	public void setIdcurso(long idcurso) {
		this.idcurso = idcurso;
	}
	
	/**
	 * @return Obtienes el valor de nombrelocalidad del tipo String
	 */
	
	public String getNombrelocalidad() {
		return nombrelocalidad;
	}
	
	/**
	 * @param Agregar el valor a nombrelocalidad del tipo String
	 */
	
	public void setNombrelocalidad(String nombrelocalidad) {
		this.nombrelocalidad = nombrelocalidad;
	}
	
	/**
	 * @return Obtienes el valor de nombregrado del tipo String
	 */
	
	public String getNombregrado() {
		return nombregrado;
	}
	
	/**
	 * @param Agregar el valor a nombregrado del tipo String
	 */
	
	public void setNombregrado(String nombregrado) {
		this.nombregrado = nombregrado;
	}
	
	/**
	 * @return Obtienes el valor de nombrecompleto del tipo String
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	
	/**
	 * @param Agregar el valor a nombrecompleto del tipo String
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	/**
	 * @return Obtienes el valor de nombreestado del tipo String
	 */
	
	public String getNombreestado() {
		return nombreestado;
	}
	
	/**
	 * @param Agregar el valor a nombreestado del tipo String
	 */
	
	public void setNombreestado(String nombreestado) {
		this.nombreestado = nombreestado;
	}
	
	/**
	 * @return Obtienes el valor de nombremunicipio del tipo String
	 */
	
	public String getNombremunicipio() {
		return nombremunicipio;
	}
	
	/**
	 * @param Agregar el valor a nombremunicipio del tipo String
	 */
	
	public void setNombremunicipio(String nombremunicipio) {
		this.nombremunicipio = nombremunicipio;
	}
	
	/**
	 * @return Obtienes el valor de idcarrera2 del tipo int
	 */
	
	public int getIdcarrera2() {
		return idcarrera2;
	}
	
	/**
	 * @param Agregar el valor a idcarrera2 del tipo int
	 */
	
	public void setIdcarrera2(int idcarrera2) {
		this.idcarrera2 = idcarrera2;
	}
	
	
}
