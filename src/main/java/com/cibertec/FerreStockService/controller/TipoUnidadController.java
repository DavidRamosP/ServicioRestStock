package com.cibertec.FerreStockService.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.FerreStockService.business.impl.TipoUnidadesServiceImpl;
import com.cibertec.FerreStockService.model.TipoUnidad;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tipounidad")
@AllArgsConstructor
public class TipoUnidadController {

	private TipoUnidadesServiceImpl service;
	
	@GetMapping("/listarTipoUnidades")
	public List<TipoUnidad> listarTipoUnidades(){
		return service.listarTiposUnidades();
	}
	
	@PostMapping("/agregarTipoUnidad")
	public TipoUnidad agregarTipoUnidad(@RequestBody TipoUnidad tipoUnidad) {
		return service.agregarNuevoTipoUnidad(tipoUnidad);
	}
}
