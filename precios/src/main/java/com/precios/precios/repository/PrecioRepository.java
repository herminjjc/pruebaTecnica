package com.precios.precios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.precios.precios.entities.Precio;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long>, PrecioRepositoryCustom {

}
