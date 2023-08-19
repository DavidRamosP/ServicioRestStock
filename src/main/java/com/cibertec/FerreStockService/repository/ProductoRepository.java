package com.cibertec.FerreStockService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockService.model.Producto;
import com.cibertec.FerreStockService.model.Proveedor;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findAllProductoByProveedorRuc(String ruc);
}
