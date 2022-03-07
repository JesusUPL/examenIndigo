package com.indigo.springbootindigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indigo.springbootindigo.entity.Persona;
import com.indigo.springbootindigo.repository.PersonaRepository;
import com.indigo.springbootindigo.service.PersonaService;

@Service
/**
 * @author Jesus Uriel Perez Lozada
 * @implNote implemetacion del service para personas
 * @version 1.0
 * */
public class PeronaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	/**
	 * @apiNote metodo para obtener a todas las personas de la base de datos
	 * @return retorna todas las personas de la base de datos
	 * */
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	/**
	 * @apiNote metodo para encontrar por medio del id 
	 * @param se obtiene el id de la personas para ir a buscarlo a la base de datos 
	 * @return devuelve los datos de la persona que fue a buscar por el id
	 * */
	public Persona findId(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	/**
	 * @apiNote metodo para guarda a nuevas personas 
	 * @param obtiene el body con los datos de la persona para guardar
	 * @return retorna la persona guardad con el datos como id
	 * 
	 * */
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
		
	}

	@Override
	@Transactional
	/**
	 * @apiNote metodo para eliminar por medio del id a personas
	 * @param se obtiene el id para ir a buscar a persona para eliminar
	 * */
	public void delete(Long id) {
		personaRepository.deleteById(id);
		
	}

}
