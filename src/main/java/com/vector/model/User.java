package com.vector.model;

/**
 * @author Claudio
 *
 */
public class User
{
	private Integer id;
	private String nombre;
	private String contra;
	private String verlogin;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getVerlogin() {
		return verlogin;
	}

	public void setVerlogin(String verlogin) {
		this.verlogin = verlogin;
	}

	public User()
	{
	}

	public User(Integer id, String name)
	{
		this.id = id;
		this.nombre = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;	}

	public void setNombre(String name)
	{
		this.nombre = name;
	}

}
