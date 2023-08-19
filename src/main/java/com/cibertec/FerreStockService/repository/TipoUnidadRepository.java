package com.cibertec.FerreStockService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockService.model.TipoUnidad;


@Repository
public interface TipoUnidadRepository extends JpaRepository<TipoUnidad, Integer> {

	// para buscar nuevo ingreso por abreviatura para registros desde productos	
		TipoUnidad findByAbreviatura(String abreviatura);
}
