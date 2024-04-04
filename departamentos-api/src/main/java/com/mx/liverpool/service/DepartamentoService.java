package com.mx.liverpool.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.liverpool.api.dto.DepartmentoDto;
import com.mx.liverpool.dao.IDepartamentoDao;
import com.mx.liverpool.dao.IEmpleadoDao;
import com.mx.liverpool.dto.EmpleadoDto;
import com.mx.liverpool.dto.EmpleadoRespDto;
import com.mx.liverpool.dto.RespuestaDto;
import com.mx.liverpool.model.Departamento;
import com.mx.liverpool.model.Empleado;

@Service
public class DepartamentoService {

	@Autowired
	private IDepartamentoDao iDepartamentoDao;
	
	@Autowired
	private IEmpleadoDao iEmpleadoDao; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 
	 * @return {@link RespuestaDto}
	 */
	public RespuestaDto obtenerDepartamentos() {
		List<Departamento> departamentos = iDepartamentoDao.findAll();
		
		if (departamentos.isEmpty()) {
			DepartmentoDto departmentoDto = consultaDepartamentos();
			departamentos = departmentoDto.getDepartamentos().stream()
			.map(nombre -> iDepartamentoDao.save(new Departamento(nombre)))
			.collect(Collectors.toList());
		}
		return new RespuestaDto("Resultado de la busqueda.", departamentos);
	}

	
	/**
	 * 
	 * @return {@link DepartmentoDto}
	 */
	private DepartmentoDto consultaDepartamentos(){
		String url = "http://localhost:/api/v1/departments";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);		
		return restTemplate.exchange(url, HttpMethod.GET, entity, DepartmentoDto.class).getBody();
	}

	/**
	 * 
	 * @param empleadoDto
	 * @return {@link RespuestaDto}
	 */
	public RespuestaDto guardarEmpleado(EmpleadoDto empleadoDto) {
		Empleado empleado = iEmpleadoDao.save(
				new Empleado(empleadoDto.getNombre(), empleadoDto.getIdDepartamento()));
		return new RespuestaDto("Empleado se registro correctamente",empleado.getId());
	}

	/**
	 * 
	 * @return {@link EmpleadoRespDto}
	 */
	public EmpleadoRespDto obtenerEmpleados() {
		List<Empleado> empleados = iEmpleadoDao.findAll();
		if(empleados.isEmpty()) {
			return new EmpleadoRespDto("No se encontraron Empleados",null);	
		}
		
		return new EmpleadoRespDto("Se encontraron Empleados",
				empleados.stream().map(empleado -> new EmpleadoDto(empleado.getId(), 
						empleado.getNombre(), 
						empleado.getDepartamento().getId()))
				.collect(Collectors.toList()));
	}


	/**
	 * 
	 * @param id
	 * @return
	 */
	public EmpleadoDto obtenerEmpleado(Long id) {
		Empleado empleado = iEmpleadoDao.findById(id).orElse(null);
		if(empleado == null) {
			return new EmpleadoDto();
		}
		return new EmpleadoDto(empleado.getId(), 
				empleado.getNombre(), 
				empleado.getDepartamento().getId());
	}
}
