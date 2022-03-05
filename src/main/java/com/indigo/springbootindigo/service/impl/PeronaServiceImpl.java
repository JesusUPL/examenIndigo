package com.indigo.springbootindigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indigo.springbootindigo.entity.Persona;
import com.indigo.springbootindigo.repository.PersonaRepository;
import com.indigo.springbootindigo.service.PersonaService;

@Service
public class PeronaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Persona findId(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Persona persona) {
		personaRepository.save(persona);
		
	}

	@Override
	public void delete(Long id) {
		personaRepository.deleteById(id);
		
	}

}
