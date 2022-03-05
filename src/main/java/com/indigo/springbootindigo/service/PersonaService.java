package com.indigo.springbootindigo.service;

import com.indigo.springbootindigo.entity.Persona;

public interface PersonaService {
	
public Iterable<Persona> findAll();
	
	public Persona findId();
	
	public void save();
	
	public void delete();

}
