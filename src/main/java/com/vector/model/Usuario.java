package com.vector.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {


	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_SPRING")
	@SequenceGenerator(name = "SEQUENCE_SPRING", allocationSize = 1, sequenceName = "seq_spring")
	private long id;
	private String nombre;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
