package com.idat.seg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "motor")
@Entity
public class Motor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMotor;
	private String descripcion;
	
	@OneToMany(mappedBy = "motor")
	private List<Auto> auto = new ArrayList<>();

	public Integer getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(Integer idMotor) {
		this.idMotor = idMotor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
