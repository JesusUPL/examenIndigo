package com.indigo.springbootindigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indigo.springbootindigo.entity.Persona;

/**
 * @author Jesus Uriel Perez Lozada
 * @version 1.0
 * @apiNote Repository con JPA repository para persona
 * */
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
