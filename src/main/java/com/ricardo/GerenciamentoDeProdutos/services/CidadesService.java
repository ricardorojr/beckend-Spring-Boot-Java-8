package com.ricardo.GerenciamentoDeProdutos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.GerenciamentoDeProdutos.entities.Cidades;
import com.ricardo.GerenciamentoDeProdutos.repository.CidadesRepository;

@Service
public class CidadesService {

	@Autowired
	private CidadesRepository cidades;

	public List<Cidades> findAll() {
		return cidades.findAll();
	}

	public Optional<Cidades> findById(Long id) {
		return cidades.findById(id);
	}

	public Cidades Salva(Cidades cidade) {
		return cidades.save(cidade);
	}

	public void delete(Cidades cidade) {
		cidades.delete(cidade);
	}

	private void updateDate(Cidades entity, Cidades obj) {
		entity.setCidade(obj.getCidade());
		
	}

	public Cidades update(Long id, Cidades obj) {
		Cidades entity = cidades.getOne(id);
		updateDate(entity, obj);
		return cidades.save(entity);
	}
}
