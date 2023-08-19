package com.cibertec.FerreStockService.business;

import java.util.List;

import com.cibertec.FerreStockService.model.Producto;
import com.cibertec.FerreStockService.model.Proveedor;

public interface ProductoService {

	public List<Producto> obtenerProductos();
	public Producto nuevoProducto(Producto producto);
	public Producto buscarProducto(int sku);
	public Producto actualizarProducto(int sku, Producto producto);
	public void eliminarProducto(int sku);
	public List<Producto> obtenerProductosPorProveedor(String ruc);
	
}
