package com.mx.liverpool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empleado {

	public Empleado() {
		super();
	}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Empleado(String nombre, Long idDepartamento) {
		super();
		this.nombre = nombre;
		this.departamento = new Departamento(idDepartamento);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToOne
	private Departamento departamento;
}
