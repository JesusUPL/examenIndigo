package com.indigo.springbootindigo.service;

import com.indigo.springbootindigo.entity.Identificacion;

public interface IdentificacionService {
	
	public Iterable<Identificacion> findAll();
	
	public Identificacion findId();
	
	public void save();
	
	public void delete();

}
