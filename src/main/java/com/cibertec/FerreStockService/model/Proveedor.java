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

/**
 * @author dramos
 * 
 * @version 1.0
 * @since 0.1
 */
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}
