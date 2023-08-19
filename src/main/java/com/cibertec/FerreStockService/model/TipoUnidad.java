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
@Table(name = "tb_tipo_unidad_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoUnidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="COD_UND_PRODUC")
	private int id;
	
	@Column(name ="TIPO_UND_PRODUC",nullable = false)
	private String abreviatura;
	
	@Column(name ="NOMBRE_UND_PRODUCTO",nullable =false)
	private String nombre;
	
		
}
