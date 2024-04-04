package com.mx.liverpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.liverpool.dto.EmpleadoDto;
import com.mx.liverpool.dto.EmpleadoRespDto;
import com.mx.liverpool.dto.RespuestaDto;
import com.mx.liverpool.service.DepartamentoService;

@RestController
@RequestMapping(value = "/v1")
public class DepartamentosController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping(value = "/departamentos")
	@ResponseBody
	public RespuestaDto obtenerDepartamentos() {		
		return departamentoService.obtenerDepartamentos();
	}	
	
	@PostMapping(value = "/guardar-empleado")
	@ResponseBody
	public RespuestaDto guardarEmpleado(@RequestBody EmpleadoDto empleadoDto) {			
		return departamentoService.guardarEmpleado(empleadoDto);
	}
	
	@GetMapping(value = "/empleados")
	@ResponseBody
	public EmpleadoRespDto obtenerEmpleados() {		
		return departamentoService.obtenerEmpleados();
	}
	
	@GetMapping(value = "/empleado/{id}")
	@ResponseBody
	public EmpleadoDto obtenerEmpleado(@PathVariable("id") Long id) {
		return departamentoService.obtenerEmpleado(id);
	}
}
