package com.cibertec.FerreStockService.business;

import java.util.List;

import com.cibertec.FerreStockService.model.Proveedor;

public interface ProveedorService {

	List<Proveedor> listarProveedores();
	Proveedor agregarProveedor(Proveedor proveedor);
	Proveedor buscarProveedorPorId(int id);
	Proveedor actualizarProveedor(int id, Proveedor proveedor);
	void eliminarProveedor(int id);
}
