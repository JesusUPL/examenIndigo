package com.indigo.springbootindigo.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void PersonaTest() {
		Persona persona = new Persona();
		
		persona.setNombre("Jesus");
		persona.setEdad(27);
		persona.setSexo("H");
		persona.setCodigo("jnNIUNnkjNKJ");
		persona.setCreacionRegistro(new Date("2022-03-07"));
		
		
		String esperadoNombre = "Jesus";
		String realNombre = persona.getNombre();
		
		int esperadoEdad = 27;
		int realEdad = persona.getEdad();
		
		String esperaSexo = "H";
		String realSexo = persona.getSexo();
		
		String esperaCodigo = "jnNIUNnkjNKJ";
		String realCodigo = persona.getCodigo();
		
		Date esperaDate = new Date("2022-03-07");
		Date realDate = persona.getCreacionRegistro();
		
		assertEquals(esperadoNombre, realNombre);
		
		
	}

}
