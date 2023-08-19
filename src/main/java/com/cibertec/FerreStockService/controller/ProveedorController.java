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
import com.cibertec.FerreStockService.business.impl.ProveedorServiceImpl;
import com.cibertec.FerreStockService.model.Proveedor;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/proveedor")
@AllArgsConstructor
public class ProveedorController {

	private ProveedorServiceImpl service;
	
	@GetMapping("/listarProveedores")
	public List<Proveedor> obtenerProveedores() {
		return service.listarProveedores();
	}
	
	
	//validar que no permitido duplicar datos  //data long tambien de ruc 
	
	@PostMapping("/agregarProveedor")
	public Proveedor agregarProveedor(@RequestBody Proveedor proveedor){
		return service.agregarProveedor(proveedor);
	}
	
	@PatchMapping("/actualizarProveedor/{id}")
	public Proveedor actualizarProveedor(@PathVariable(value = "id")int id, @RequestBody Proveedor proveedor) {
		return service.actualizarProveedor(id, proveedor);	
	}
	
	
	@DeleteMapping("/eliminarProveedor/{id}")
	public void eliminarTienda(@PathVariable(value = "id")int id) {
		service.eliminarProveedor(id);
	}
	
}


