package com.precios.precios.repository;

import java.time.LocalDateTime;

import com.precios.precios.entities.Precio;

public interface PrecioRepositoryCustom {

	public Precio findByFiltro(LocalDateTime date, Long idProdut, Long idCadena);

}
