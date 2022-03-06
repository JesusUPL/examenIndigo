package com.indigo.springbootindigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indigo.springbootindigo.entity.Persona;
import com.indigo.springbootindigo.repository.PersonaRepository;
import com.indigo.springbootindigo.service.PersonaService;

@Service
public class PeronaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findId(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaRepository.deleteById(id);
		
	}

}
