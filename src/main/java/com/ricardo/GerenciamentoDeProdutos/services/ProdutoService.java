package com.ricardo.GerenciamentoDeProdutos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.GerenciamentoDeProdutos.entities.Produto;
import com.ricardo.GerenciamentoDeProdutos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository prod;

	public List<Produto> findAll() {
		return prod.findAll();
	}

	public Optional<Produto> findById(Long id) {
		return prod.findById(id);
	}

	public Produto Salva(Produto produto) {
		return prod.save(produto);
	}

	public void delete(Produto produto) {
		prod.delete(produto);
	}

	private void updateDate(Produto entity, Produto obj) {
		entity.setNomeProduto(obj.getNomeProduto());
		entity.setEstoque(obj.getEstoque());
		entity.setValorProduto(obj.getValorProduto());
		entity.setCodProduto(obj.getCodProduto());
	}

	public Produto update(Long id, Produto obj) {
		Produto entity = prod.getOne(id);
		updateDate(entity, obj);
		return prod.save(entity);
	}
}
