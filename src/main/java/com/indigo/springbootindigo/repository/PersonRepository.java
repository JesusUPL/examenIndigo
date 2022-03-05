package com.indigo.springbootindigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indigo.springbootindigo.entity.Persona;

public interface PersonRepository extends JpaRepository<Persona, Long>{

}
