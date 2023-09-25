package com.precios.precios.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.precios.precios.entities.Precio;
import com.precios.precios.service.PrecioService;

@WebMvcTest(PrecioRestController.class)
public class PrecioRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	PrecioService precioService;

	private String fecha1 = "2020-06-14 10:00:00";

	@Test
	@WithMockUser(username = "test", password = "test")
	public void testFecha1ok200() throws Exception {
		
		
		when(precioService.tarifaAplicar( any() ,anyLong(),anyLong())).thenReturn(getPrecio());
		
		mvc.perform(get("/precio/tarifa/").param("fecha", fecha1).
				param("idProducto", "35455").param("idCadena", "1"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(1)));
    
		verify(precioService).tarifaAplicar(any(),anyLong(), anyLong());
		
	}

	@Test
	@WithMockUser(username = "test", password = "test")
	public void testApiCuandoNoSePasanParametrostBadRequest() throws Exception {
		mvc.perform(get("/precio/tarifa")).andExpect(status().isBadRequest());
	}

	private Precio getPrecio() throws ParseException {
		String initDate = "2020-06-14 00:00:00";
		String endDate = "2020-12-31 23:59:59";

		return new Precio(1l, 1l, LocalDateTime.parse(initDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
				LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 1l, 35455l, 1l, 35.50,
				"EUR");
	}

}
