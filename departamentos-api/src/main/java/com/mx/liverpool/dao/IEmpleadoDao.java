package com.mx.liverpool.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.liverpool.model.Empleado;

@Repository
public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {

	@Override
    List<Empleado> findAll();
}
