package com.cibertec.FerreStockService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tienda_ferreteria")
@Data
@NoArgsConstructor
public class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "COD_TIENDA")
	private int id;
	
	@Column(name = "RUC_TIENDA" , nullable = false, unique = true)
	private String ruc;
	
	@Column(name = "NOMBRE_TIENDA", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "DIRECCION_TIENDA", nullable = false)
	private String direccion;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
