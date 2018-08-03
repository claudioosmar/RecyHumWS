package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
public class BeanDatosLogin {
	private int ID_login;
	
	@NotNull
	@Size (min = 3, max=250)
	@NotBlank
	@NotEmpty
	private String User;
	private String token;
	
	@NotNull
	@Size(min = 8, max=250)
	@NotBlank
	@NotEmpty
	private String pass;
	
	private String urlFoto;
	
	
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public int getID_login() {
		return ID_login;
	}
	public void setID_login(int iD_login) {
		ID_login = iD_login;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
