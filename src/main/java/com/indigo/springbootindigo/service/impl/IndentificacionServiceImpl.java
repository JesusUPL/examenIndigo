package com.indigo.springbootindigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indigo.springbootindigo.entity.Identificacion;
import com.indigo.springbootindigo.repository.IdentificacionRepository;
import com.indigo.springbootindigo.service.IdentificacionService;

@Service
/**
 * @author Jesus Uriel Perez Lozada
 * @implNote implemetacion del service para identificaciones
 * @version 1.0
 * */
public class IndentificacionServiceImpl implements IdentificacionService{
	
	@Autowired
	private IdentificacionRepository identificacionRepository;

	@Override
	@Transactional(readOnly = true)
	/**
	 * @apiNote metodo para obtener todos los registros de las identificaciones
	 * @return retorna un Iterable con todo los datos de las identificaciones de las personas
	 * */
	public Iterable<Identificacion> findAll() {
		// TODO Auto-generated method stub
		return identificacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	/**
	 * @apiNote metodo para encontrar la identificacion por id de cada persona
	 * @param el parametro que se le pasa es el id
	 * @return retorna a identificacion encontrada por el id
	 * */
	public Identificacion findId(Long id) {
		// TODO Auto-generated method stub
		return identificacionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	/**
	 * @apiNote metodo para guardar identificacion de cada persona 
	 * @param se pasa la identificacion con los datos 
	 * @return retorna la identificacion guardada
	 * 
	 * */
	public Identificacion save(Identificacion identificacion) {
		return identificacionRepository.save(identificacion);
		
	}

	@Override
	@Transactional
	/**
	 * @apiNote metodo para eliminar identificaciones de persona
	 * @param se pasa el id de la identifacion 
	 * */
	public void delete(Long id) {
		identificacionRepository.deleteById(id);
		
	}

}
