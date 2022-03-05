package com.indigo.springbootindigo.service;

import com.indigo.springbootindigo.entity.Persona;

public interface PersonaService {
	
public Iterable<Persona> findAll();
	
	public Persona findId(Long id);
	
	public void save(Persona persona);
	
	public void delete(Long id);

}
