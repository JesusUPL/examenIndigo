package com.indigo.springbootindigo.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = -4839806247658244742L;


	public Persona() {
	
	}
	
	public Persona(String nombre, int edad ) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Persona(String nombre, int edad, String sexo, String codigo, Date creacionRegistro) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = " ";
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creacionRegistro;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "identificaciones")
	@JoinColumn(name = "persona_id")
	private List<Identificacion> identificaciones; 
	
	
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
		this.codigo = this.generateStringRamdon();
	}
	public Date getCreacionRegistro() {
		return creacionRegistro;
	}
	public void setCreacionRegistro(Date creacionRegistro) {
		this.creacionRegistro = creacionRegistro;
	} 
	
	public List<Identificacion> getIdentificaciones() {
		return identificaciones;
	}

	public void setIdentificaciones(List<Identificacion> identificaciones) {
		this.identificaciones = identificaciones;
	}

	public String generateStringRamdon(){
		String caracter  = "abcdefghijklmnopqrstuvwxyz";
		String caracterUp = caracter.toUpperCase();
		
		String cadenasRandom = caracter + caracterUp;
		SecureRandom random = new SecureRandom();
		
		if (10 < 1) throw new IllegalArgumentException();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<10 ; i++) {
			int lenRm = random.nextInt(cadenasRandom.length());
			char rnchar = cadenasRandom.charAt(lenRm);
			
			sb.append(rnchar);
		}
		
		return sb.toString();
	}
}
