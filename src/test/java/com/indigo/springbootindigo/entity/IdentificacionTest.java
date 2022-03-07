package com.indigo.springbootindigo.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class IdentificacionTest {

	@Test
	void identificaionTest() {
		Identificacion identificacion = new Identificacion();
		
		identificacion.setNombreIdentificacion("INE");
		identificacion.setDescripcion("se obtiene la ine del cliente");
		identificacion.setFechaCreacion(new Date("2022-03-07"));
		
		
		assertEquals("INE", identificacion.getNombreIdentificacion());
	}

}
