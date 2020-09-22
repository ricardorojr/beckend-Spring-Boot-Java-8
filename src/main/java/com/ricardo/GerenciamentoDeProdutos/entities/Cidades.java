package com.ricardo.GerenciamentoDeProdutos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cidade")
public class Cidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCidade;

	private String cidade;

	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Produto> produto;

	public Cidades(Long idCidade, String cidade, List<Produto> produto) {
		super();
		this.idCidade = idCidade;
		this.cidade = cidade;
		this.produto = produto;
	}

	public Cidades() {
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		produto = produto;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
