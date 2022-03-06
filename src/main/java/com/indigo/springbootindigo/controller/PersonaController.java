package com.indigo.springbootindigo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indigo.springbootindigo.entity.Persona;
import com.indigo.springbootindigo.service.PersonaService;

@RestController
@RequestMapping(value = "/api/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public ResponseEntity<?> create (@RequestBody Persona persona){
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> read (@PathVariable(value = "id") Long id){
		Persona persona = personaService.findId(id);
		
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(persona);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Persona persona, @PathVariable(value = "id")Long id){
		Persona obtenerPersona = personaService.findId(id);
		
		if(obtenerPersona == null) {
			return ResponseEntity.notFound().build();
		}
		
		obtenerPersona.setNombre(persona.getNombre());
		obtenerPersona.setEdad(persona.getEdad());
		obtenerPersona.setSexo(persona.getSexo());
		obtenerPersona.setCodigo(persona.getCodigo());
		obtenerPersona.setCreacionRegistro(persona.getCreacionRegistro());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(obtenerPersona));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete (@PathVariable(value = "id")Long id){
		Persona persona = personaService.findId(id);
		
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		
		personaService.delete(id);
		return ResponseEntity.ok().build();
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Persona> readAll (){
		List<Persona> personas = StreamSupport
				.stream(personaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return personas;
	}

}
