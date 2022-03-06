package com.indigo.springbootindigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indigo.springbootindigo.entity.Identificacion;
import com.indigo.springbootindigo.repository.IdentificacionRepository;
import com.indigo.springbootindigo.service.IdentificacionService;

@Service
public class IndentificacionServiceImpl implements IdentificacionService{
	
	@Autowired
	private IdentificacionRepository identificacionRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Identificacion> findAll() {
		// TODO Auto-generated method stub
		return identificacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Identificacion findId(Long id) {
		// TODO Auto-generated method stub
		return identificacionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Identificacion save(Identificacion identificacion) {
		return identificacionRepository.save(identificacion);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		identificacionRepository.deleteById(id);
		
	}

}
