package com.cibertec.FerreStockService.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.FerreStockService.business.TipoUnidadService;
import com.cibertec.FerreStockService.model.TipoUnidad;
import com.cibertec.FerreStockService.repository.TipoUnidadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoUnidadesServiceImpl implements TipoUnidadService {

	private TipoUnidadRepository repository;
	
	@Override
	public List<TipoUnidad> listarTiposUnidades() {
		return repository.findAll();
	}

	@Override
	public TipoUnidad agregarNuevoTipoUnidad(TipoUnidad tipoUnidad) {
		return repository.save(tipoUnidad);
	}
	
	

}
