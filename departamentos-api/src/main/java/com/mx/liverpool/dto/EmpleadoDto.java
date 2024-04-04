package com.mx.liverpool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDto {

	public EmpleadoDto() {
		
	}
	
	public EmpleadoDto(Long idEmpleado, String nombre, Long idDepartameto) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.idDepartamento = idDepartameto;
	}
	
	private Long idEmpleado;
	
	private String nombre;
	
	private Long idDepartamento;
	
}
