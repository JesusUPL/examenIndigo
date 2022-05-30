package com.indigo.springbootindigo.entity;

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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "identificacion")
public class Identificacion implements Serializable {

	private static final long serialVersionUID = 5309102805223683092L;

	public Identificacion() {

	}

	public Identificacion(String nombreIdentificacion, String descripcion) {
		this.nombreIdentificacion = nombreIdentificacion;
		this.descripcion = descripcion;
	}

	public Identificacion(String nombreIdentificacion, String descripcion, Date fechaCreacion) {
		this.nombreIdentificacion = nombreIdentificacion;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "identificationName")
	private String nombreIdentificacion;

	@NotNull
	@Column(name = "description")
	private String descripcion;

	@Column(name = "createdAt")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCreacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreIdentificacion() {
		return nombreIdentificacion;
	}

	public void setNombreIdentificacion(String nombreIdentificacion) {
		this.nombreIdentificacion = nombreIdentificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
