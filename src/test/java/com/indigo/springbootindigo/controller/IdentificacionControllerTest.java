package com.indigo.springbootindigo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
class IdentificacionControllerTest {
	
	private static final String URL = "/api/identificaciones";
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void readTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.get(URL.concat("/1"))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	void readAll() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.get(URL.concat("/"))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

}
