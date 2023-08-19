package com.cibertec.FerreStockService.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockService.model.Tienda;


@Repository
public interface TiendaRepository extends CrudRepository<Tienda, Integer>, PagingAndSortingRepository<Tienda, Integer>{

}
