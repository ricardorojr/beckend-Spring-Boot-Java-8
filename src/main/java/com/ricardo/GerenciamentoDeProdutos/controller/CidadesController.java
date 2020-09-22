package com.ricardo.GerenciamentoDeProdutos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardo.GerenciamentoDeProdutos.entities.Cidades;
import com.ricardo.GerenciamentoDeProdutos.services.CidadesService;

@RestController
@RequestMapping(value = "/cities")
public class CidadesController {

	@Autowired
	private CidadesService CidServ;

	@GetMapping
	public ResponseEntity<List<Cidades>> getAll() {
		List<Cidades> list = CidServ.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Cidades>> findById(@PathVariable Long id) {
		Optional<Cidades> obj = CidServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Cidades> insert(@RequestBody Cidades obj) {
		obj = CidServ.Salva(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCidade()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cidades> deleteLive(@PathVariable(value = "id") Long id) {
		Optional<Cidades> cidade = CidServ.findById(id);
		if (!cidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			CidServ.delete(cidade.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cidades> atualiza(@PathVariable Long id, @RequestBody Cidades obj) {
		obj = CidServ.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
