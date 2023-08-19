package com.cibertec.FerreStockService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockService.model.Proveedor;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	Proveedor findProveedorByRuc(String ruc);
}
