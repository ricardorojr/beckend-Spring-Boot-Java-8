package com.ricardo.GerenciamentoDeProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.GerenciamentoDeProdutos.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
