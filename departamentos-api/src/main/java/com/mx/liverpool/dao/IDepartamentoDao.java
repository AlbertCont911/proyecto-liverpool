package com.mx.liverpool.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.liverpool.model.Departamento;

@Repository
public interface IDepartamentoDao extends CrudRepository<Departamento, Integer> {

	@Override
    List<Departamento> findAll();
}
