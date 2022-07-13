package com.idat.seg.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name = "autos")
@Entity
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAutos;
	private String cilindraje;
	private String potencia;
	private Integer precio;
	private String observaciones;
	
	@ManyToOne
	@JoinColumn(
			name = "id_marca", nullable = false, unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_marca) references marca(id_marca)")
			)
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(
			name = "id_motor", nullable = false, unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_motor) references motor(id_motor)")
			)
	private Motor motor;
	
	
	public Integer getIdAutos() {
		return idAutos;
	}
	public void setIdAutos(Integer idAutos) {
		this.idAutos = idAutos;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public String getPotencia() {
		return potencia;
	}
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
