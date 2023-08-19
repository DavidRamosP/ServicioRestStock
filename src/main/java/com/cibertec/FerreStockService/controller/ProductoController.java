package com.cibertec.FerreStockService.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.FerreStockService.business.impl.ProductoServiceImpl;
import com.cibertec.FerreStockService.model.Producto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {


	private ProductoServiceImpl service;
	
	@GetMapping("/listarProductos")
	public List<Producto> obtenerProductos() {
		return service.obtenerProductos();
	}
	
	@PostMapping("/agregarProducto")
	public ResponseEntity<Producto> nuevoProducto(@RequestBody Producto producto) {
		Producto agregado = service.nuevoProducto(producto);
		if(agregado!=null) {
			return new ResponseEntity<Producto>(agregado, HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	@PatchMapping("/actualizarProducto/{sku}")
	public ResponseEntity<Producto>  actualizarProducto(@PathVariable(value = "sku")int sku, @RequestBody Producto producto) {
		Producto prod = service.buscarProducto(sku);
		if(prod==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<Producto>(service.actualizarProducto(sku, producto), HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/eliminarProducto/{id}")
	public ResponseEntity<?> eliminarTienda(@PathVariable(value = "id")int id) {
		Producto found = service.buscarProducto(id);
		if(Objects.nonNull(found)) {
			service.eliminarProducto(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listarProductos/{ruc}")
	public ResponseEntity<List<Producto>>  obtenerProductosPorRuc(@PathVariable(value = "ruc") String ruc) {
		List<Producto> lista = service.obtenerProductosPorProveedor(ruc);
		
		if(lista.size()<1) {
			return new ResponseEntity<>(lista, HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
