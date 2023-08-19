package com.cibertec.FerreStockService.business.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.cibertec.FerreStockService.business.ProveedorService;
import com.cibertec.FerreStockService.model.Proveedor;
import com.cibertec.FerreStockService.repository.ProveedorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

	private ProveedorRepository repository;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return repository.findAll();
	}

	@Override
	public Proveedor agregarProveedor(Proveedor proveedor) {
		return repository.save(proveedor);
	}

	@Override
	public Proveedor buscarProveedorPorId(int id) {
		return repository.findById(id).get();
	}


	@Override
	public void eliminarProveedor(int id) {
		repository.deleteById(id);
	}

	@Override
	public Proveedor actualizarProveedor(int id, Proveedor proveedor) {
		Proveedor foundProveedor = repository.findById(id).orElse(null);
		if(Objects.nonNull(foundProveedor)) {
			foundProveedor.setId(id);
			foundProveedor.setRuc(proveedor.getRuc());
			foundProveedor.setNombre(proveedor.getNombre());
			foundProveedor.setMarca(proveedor.getMarca());
		}
		return repository.save(foundProveedor);
	}
	
}
