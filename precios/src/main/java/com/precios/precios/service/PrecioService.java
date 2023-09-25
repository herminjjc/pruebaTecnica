package com.precios.precios.service;

import java.time.LocalDateTime;

import com.precios.precios.entities.Precio;

public interface PrecioService {

	public Precio tarifaAplicar(LocalDateTime date, Long isProduct, Long idCadena);

}
