package com.precios.precios.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.precios.precios.entities.Precio;
import com.precios.precios.repository.PrecioRepository;

@Service
public class PrecioServiceImpl implements PrecioService {

	@Autowired
	private PrecioRepository precioRepository;

	@Override
	public Precio tarifaAplicar(LocalDateTime date, Long isProduct, Long idCadena) {

		return precioRepository.findByFiltro(date, isProduct, idCadena);
	}

}
