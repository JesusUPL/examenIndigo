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

import com.indigo.springbootindigo.entity.Identificacion;
import com.indigo.springbootindigo.service.IdentificacionService;

@RestController
@RequestMapping(value = "/api/identificaciones")
public class IdentificacionController {

	@Autowired
	private IdentificacionService identificacionService;

	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public ResponseEntity<?> created(@RequestBody Identificacion identificacion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(identificacionService.save(identificacion));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
		Identificacion identificacion = identificacionService.findId(id);
		
		if(identificacion == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(identificacion);
	}
	
	@RequestMapping(value = "/update/{id}")
	public ResponseEntity<?> update (@RequestBody Identificacion identificacion, @PathVariable(value = "id")Long id){
		Identificacion obtenerIdentificacion = identificacionService.findId(id);
		
		if (obtenerIdentificacion == null) {
			return ResponseEntity.notFound().build();
		}
		
		obtenerIdentificacion.setNombreIdentificacion(identificacion.getNombreIdentificacion());
		obtenerIdentificacion.setDescripcion(identificacion.getDescripcion());
		obtenerIdentificacion.setFechaCreacion(identificacion.getFechaCreacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(identificacionService.save(obtenerIdentificacion));
		
	}
	
	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id")Long id){
		Identificacion identificacion = identificacionService.findId(id);
		
		if(identificacion == null ) {
			return ResponseEntity.notFound().build();
		}
		
		identificacionService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Identificacion> readAll(){
		List<Identificacion> identificaciones = StreamSupport
				.stream(identificacionService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return identificaciones;
	}

}
