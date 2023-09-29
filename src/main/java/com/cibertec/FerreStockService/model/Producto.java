package com.cibertec.FerreStockService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKU_PRODUC")
	private int sku;
	
	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public TipoUnidad getUnidad() {
		return unidad;
	}

	public void setUnidad(TipoUnidad unidad) {
		this.unidad = unidad;
	}

	@Column(name = "NOMBRE_PRODUC")
	private String nombre;
	
	@Column(name = "PRECIO_PRODUC")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "FOR_COD_PROVEEDOR")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "FOR_COD_UND")
	private TipoUnidad unidad;
	
	
}
