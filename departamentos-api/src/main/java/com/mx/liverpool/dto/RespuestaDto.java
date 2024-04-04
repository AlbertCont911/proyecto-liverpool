package com.mx.liverpool.dto;

import java.util.List;

import com.mx.liverpool.model.Departamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaDto {

	public RespuestaDto(String mensaje, Long idEmpleado) {
		super();
		this.mensaje = mensaje;
		this.idEmpleado = idEmpleado;
	}
	
	public RespuestaDto(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public RespuestaDto(String mensaje, List<Departamento> departamentos) {
		super();
		this.mensaje = mensaje;
		this.departamentos = departamentos;
	}

	private String mensaje;
	
	private List<Departamento> departamentos;
	
	private Long idEmpleado;
}
