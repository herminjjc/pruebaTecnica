package com.precios.precios.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.precios.precios.entities.Precio;
import com.precios.precios.service.PrecioService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/precio")
public class PrecioRestController {

	@Autowired
	private PrecioService precioService;

	@GetMapping("/tarifa")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Precio.class))) })
	public ResponseEntity<Precio> getPrecioFecha(
			@Parameter(in = ParameterIn.QUERY, description = "Fecha en formato yyy-MM-dd HH:mm:ss", schema = @Schema()) @RequestParam(value = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fecha,
			@Parameter(in = ParameterIn.QUERY, description = "Id del producto", schema = @Schema()) @RequestParam(value = "idProducto") Long idProducto,
			@Parameter(in = ParameterIn.QUERY, description = "Id de la cadena", schema = @Schema()) @RequestParam(value = "idCadena") Long idCadena) {

		Precio precio = precioService.tarifaAplicar(fecha, idProducto, idCadena);

		if (precio != null)
			return ResponseEntity.ok(precio);
		else
			return ResponseEntity.notFound().build();

	}

}
