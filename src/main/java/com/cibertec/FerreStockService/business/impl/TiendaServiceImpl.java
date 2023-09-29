package com.cibertec.FerreStockService.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.FerreStockService.business.TiendaService;
import com.cibertec.FerreStockService.model.Tienda;
import com.cibertec.FerreStockService.repository.TiendaRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TiendaServiceImpl implements TiendaService {

	
	private TiendaRepository repository;
	
	@Override
	public List<Tienda> obtenerTiendas(){
		List<Tienda> listado = new ArrayList<Tienda>();
		repository.findAll().forEach(tienda -> {listado.add(tienda);});
		return listado;
	}
	@Override
	public Tienda nuevaTienda(Tienda tienda) {
		return repository.save(tienda);
	}
	
	@Override
	public Tienda buscarTienda(int id) {
		Tienda tiendaEncontrada = repository.findById(id).get();
		return tiendaEncontrada;
	}
	
	@Override
	public void eliminarTienda(int id) {
		repository.deleteById(id);
	}
	@Override
	public Tienda actualizar(int id, Tienda tienda) {
		Tienda foundTienda = repository.findById(id).orElse(null);
		if(foundTienda!=null) {
			foundTienda.setId(id);
			foundTienda.setDireccion(tienda.getDireccion());
			foundTienda.setNombre(tienda.getNombre());
			foundTienda.setRuc(tienda.getRuc());
		}
		
		return repository.save(foundTienda);
	}
	

}