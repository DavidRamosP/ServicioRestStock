package com.cibertec.FerreStockService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="proveedor")
@Getter
@Setter
@NoArgsConstructor
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PROVEEDOR")
	private int id;
	
	@Column(name = "RUC_PROVEEDOR" , nullable = false, unique = true)
	private String ruc;
	
	
	@Column(name = "NOMBRE_PROVEEDOR", nullable = false, unique = true)
	private String nombre;
	
	
	@Column(name = "MARCA_PROVEEDOR", nullable = false, unique = true)
	private String marca;
}
