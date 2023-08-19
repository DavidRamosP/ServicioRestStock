package com.cibertec.FerreStockService.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.FerreStockService.business.impl.TiendaServiceImpl;
import com.cibertec.FerreStockService.model.Tienda;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tiendas")
@AllArgsConstructor
public class TiendaController {


	private TiendaServiceImpl service;
	
	@GetMapping("/listarTiendas")
	public List<Tienda> obtenerTiendas() {
		return service.obtenerTiendas();
	}
	
	
	@PostMapping("/nuevaTienda")
	public Tienda nuevaTienda(@RequestBody Tienda tienda) {
		return service.nuevaTienda(tienda);
	}
	
	
	@PatchMapping("/actualizarTienda/{id}")
	public Tienda actualizarTienda(@PathVariable(value = "id")int id, @RequestBody Tienda tienda) {
		return service.actualizar(id, tienda);
	}
	
	
	@DeleteMapping("/eliminarTienda/{id}")
	public void eliminarTienda(@PathVariable(value = "id")int id) {
		service.eliminarTienda(id);
	}
	
}
