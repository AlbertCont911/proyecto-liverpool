package com.mx.liverpool.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Departamento {

	public Departamento() {
	}
	
	public Departamento(Long id) {
		this.id=id;
	}
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombre;
	
	@OneToMany(mappedBy="departamento")
	private List<Empleado> empleados; 
}
