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

import com.ricardo.GerenciamentoDeProdutos.entities.Produto;
import com.ricardo.GerenciamentoDeProdutos.services.ProdutoService;

@RestController
@RequestMapping(value = "/products")
public class ProdutoController {

	@Autowired
	private ProdutoService prodServ;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		List<Produto> list = prodServ.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) {
		Optional<Produto> obj = prodServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto obj) {
		obj = prodServ.Salva(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodProduto()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deleteLive(@PathVariable(value = "id") Long id) {
		Optional<Produto> produto = prodServ.findById(id);
		if (!produto.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			prodServ.delete(produto.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> atualiza(@PathVariable Long id, @RequestBody Produto obj) {
		obj = prodServ.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
