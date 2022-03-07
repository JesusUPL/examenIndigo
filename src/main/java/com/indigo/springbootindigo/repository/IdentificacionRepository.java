package com.indigo.springbootindigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indigo.springbootindigo.entity.Identificacion;

/**
 * @author Jesus Uriel Perez Lozada
 * @version 1.0
 * @apiNote Repository con JPA repository para identificacion
 * */
public interface IdentificacionRepository extends JpaRepository <Identificacion, Long>{

}
