package com.indigo.springbootindigo.Dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "personas")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = -4839806247658244742L;


	public Persona() {
	
	}
	
	public Persona(String nombre, int edad, String sexo, String codigo, Date creacionRegistro) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.codigo = codigo;
		this.creacionRegistro = creacionRegistro;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NonNull
	@NotBlank
	@Column(name = "name")
	private String nombre;
	
	@Column(name = "age")
	private int edad;
	
	@NotNull
	@NotBlank
	@Column(name = "gender")
	private String sexo;
	
	@NotNull
	@NotBlank
	@Column(name = "code")
	private String codigo;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.DATE)
	private Date creacionRegistro;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getCreacionRegistro() {
		return creacionRegistro;
	}
	public void setCreacionRegistro(Date creacionRegistro) {
		this.creacionRegistro = creacionRegistro;
	} 

}
