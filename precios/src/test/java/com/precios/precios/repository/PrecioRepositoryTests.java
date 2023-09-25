package com.precios.precios.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.precios.precios.entities.Precio;

@DataJpaTest
public class PrecioRepositoryTests {

	private String fecha1 = "2020-06-14 10:00:00";
	private String fecha2 = "2020-06-14 16:00:00";
	private String fecha3 = "2020-06-14 21:00:00";
	private String fecha4 = "2020-06-15 10:00:00";
	private String fecha5 = "2020-06-16 21:00:00";

	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	TestEntityManager testEntityManager;

	@Autowired
	PrecioRepositoryCustomImpl precioReposiotry;

	@Test
	public void testFindByFiltroFecha1() throws ParseException {

		Precio precio = precioReposiotry.findByFiltro(
				LocalDateTime.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455l, 1l);

		assertNotNull(precio);
		assertEquals(precio.getPriece(), 35.50);

	}

	@Test
	public void testFindByFiltroFecha2() throws ParseException {

		Precio precio = precioReposiotry.findByFiltro(
				LocalDateTime.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455l, 1l);

		assertNotNull(precio);
		assertEquals(precio.getPriece(), 25.45);

	}

	@Test
	public void testFindByFiltroFecha3() throws ParseException {

		Precio precio = precioReposiotry.findByFiltro(
				LocalDateTime.parse(fecha3, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455l, 1l);

		assertNotNull(precio);
		assertEquals(precio.getPriece(), 35.50);

	}

	@Test
	public void testFindByFiltroFecha4() throws ParseException {

		Precio precio = precioReposiotry.findByFiltro(
				LocalDateTime.parse(fecha4, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455l, 1l);

		assertNotNull(precio);
		assertEquals(precio.getPriece(), 30.50);

	}

	@Test
	public void testFindByFiltroFecha5() throws ParseException {

		Precio precio = precioReposiotry.findByFiltro(
				LocalDateTime.parse(fecha5, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 35455l, 1l);

		assertEquals(precio.getPriece(), 38.95);

	}

}
