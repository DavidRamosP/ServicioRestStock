package com.cibertec.FerreStockService.business;

import java.util.List;

import com.cibertec.FerreStockService.model.Tienda;

public interface TiendaService {

	
	public List<Tienda> obtenerTiendas();
	public Tienda nuevaTienda(Tienda tienda);
	public Tienda buscarTienda(int id);
	public void eliminarTienda(int id);
	public Tienda actualizar(int id, Tienda tienda);
}
