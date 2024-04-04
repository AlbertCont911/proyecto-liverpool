package com.mx.liverpool.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoRespDto {
	
	public EmpleadoRespDto(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public EmpleadoRespDto(String mensaje, List<EmpleadoDto> empleados) {
		super();
		this.mensaje = mensaje;
		this.empleados = empleados;
	}

	private String mensaje;
	
	private List<EmpleadoDto> empleados;
}
