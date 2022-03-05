package com.indigo.springbootindigo.service;

import com.indigo.springbootindigo.entity.Identificacion;

public interface IdentificacionService {
	
	public Iterable<Identificacion> findAll();
	
	public Identificacion findId(Long id);
	
	public void save(Identificacion identificacion);
	
	public void delete(Long id);

}
