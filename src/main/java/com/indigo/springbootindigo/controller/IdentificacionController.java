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
/**
 * @author Jesus Uriel perez Lozada 
 * @apiNote RestCOntrollers para consumir el crud de identificaciones
 * @category RestController
 * @version 1.0
 * */
public class IdentificacionController {

	@Autowired
	private IdentificacionService identificacionService;

	/**
	 * @apiNote metodo para identifiaciones y crearlas
	 * @method tipo post para mandar la info 
	 * @return el codigo de 201 created con la identificacion
	 * */
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public ResponseEntity<?> created(@RequestBody Identificacion identificacion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(identificacionService.save(identificacion));
	}

	/**
	 * 
	 * @apiNote metodo para ir por la identifiacion con el id
	 * @param se le manda el id de la identificacion
	 * @return retorna la identificacion encontrada con el id
	 * @ 
	 **/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id) {
		Identificacion identificacion = identificacionService.findId(id);
		
		if(identificacion == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(identificacion);
	}
	
	/**
	 * @method para obtener y modofocar la identificaciones de las personas
	 * @param se obtiene el id 
	 * @return retorna los valores de la identificacion modificada
	 * **/
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
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
	
	/**
	 * @method para eliminar alguna identificaion de personas
	 * @param se pasa el id para obtenerlay poder eliminarla
	 * */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete (@PathVariable(value = "id")Long id){
		Identificacion identificacion = identificacionService.findId(id);
		
		if(identificacion == null ) {
			return ResponseEntity.notFound().build();
		}
		
		identificacionService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	/**
	 * @method se obtiene todas la identificaciones 
	 * @return regresa todas las identificaciones guradadas
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Identificacion> readAll(){
		List<Identificacion> identificaciones = StreamSupport
				.stream(identificacionService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return identificaciones;
	}

}
