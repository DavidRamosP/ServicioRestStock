package com.cibertec.FerreStockService.business;

import java.util.List;

import com.cibertec.FerreStockService.model.TipoUnidad;
public interface TipoUnidadService {

	List<TipoUnidad> listarTiposUnidades();
	TipoUnidad agregarNuevoTipoUnidad(TipoUnidad tipoUnidad);
}
