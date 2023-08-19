package com.cibertec.FerreStockService.business.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.cibertec.FerreStockService.business.ProductoService;
import com.cibertec.FerreStockService.model.Producto;
import com.cibertec.FerreStockService.model.Proveedor;
import com.cibertec.FerreStockService.model.TipoUnidad;
import com.cibertec.FerreStockService.repository.ProductoRepository;
import com.cibertec.FerreStockService.repository.ProveedorRepository;
import com.cibertec.FerreStockService.repository.TipoUnidadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository repository;
	private TipoUnidadRepository repositoryTipo;
	private ProveedorRepository repositoryProveedor;
	
	@Override
	public List<Producto> obtenerProductos() {
		return repository.findAll();
	}

	@Override
	public Producto nuevoProducto(Producto producto) {
		TipoUnidad tipoUnidad = repositoryTipo.findById(producto.getUnidad().getId()).orElse(null);
		Proveedor proveedor = repositoryProveedor.findById(producto.getProveedor().getId()).orElse(null);
		
		if(Objects.isNull(tipoUnidad)) {
			TipoUnidad nuevo = new TipoUnidad();
			nuevo.setAbreviatura(producto.getUnidad().getAbreviatura());
			nuevo.setNombre(producto.getUnidad().getNombre());
			repositoryTipo.save(nuevo);
			
			tipoUnidad = repositoryTipo.findByAbreviatura(producto.getUnidad().getAbreviatura());
			producto.setUnidad(tipoUnidad);
			
			
		}else {
			producto.setUnidad(tipoUnidad);
		}
		
		if(Objects.isNull(proveedor)) {
			Proveedor nuevoPro = new Proveedor();
			nuevoPro.setMarca(producto.getProveedor().getMarca());
			nuevoPro.setNombre(producto.getProveedor().getNombre());
			nuevoPro.setRuc(producto.getProveedor().getRuc());
			repositoryProveedor.save(nuevoPro);
			
			proveedor = repositoryProveedor.findProveedorByRuc(producto.getProveedor().getRuc());
			producto.setProveedor(proveedor);
			
		}else {
			producto.setProveedor(proveedor);
		}
		
		return repository.save(producto);
	}

	@Override
	public Producto buscarProducto(int sku) {
		Producto found = repository.findById(sku).orElse(null);		
		return found;
	}

	@Override
	public void eliminarProducto(int sku) {
		repository.deleteById(sku);
		
	}

	@Override
	public Producto actualizarProducto(int sku, Producto producto) {
		Producto found = repository.findById(sku).orElse(null);
		if(found!=null) {
			found.setSku(sku);
			found.setNombre(producto.getNombre());
			found.setPrecio(producto.getPrecio());
			
			TipoUnidad tipoUnidad = repositoryTipo.findById(producto.getUnidad().getId()).get();
			Proveedor proveedor = repositoryProveedor.findById(producto.getProveedor().getId()).get();
			
			found.setUnidad(tipoUnidad);
			found.setProveedor(proveedor);
		}
		return repository.save(found);
	}

	@Override
	public List<Producto> obtenerProductosPorProveedor(String ruc) {
		/*
		List<Producto> listaNueva = repository.findAll().stream()
									.filter(producto -> producto.getProveedor().getRuc().equals(ruc))
									.collect(Collectors.toList());
		
		return listaNueva;
	*/
		
		return repository.findAllProductoByProveedorRuc(ruc) ;
	}

	

}
