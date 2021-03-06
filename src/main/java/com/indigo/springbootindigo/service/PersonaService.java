package com.indigo.springbootindigo.service;

/**
 * @author Jesus Uriel Perez Lozada
 * 
 * */
import com.indigo.springbootindigo.entity.Persona;

public interface PersonaService {
	
public Iterable<Persona> findAll();
	
	public Persona findId(Long id);
	
	public Persona save(Persona persona);
	
	public void delete(Long id);

}
