package com.ricardo.GerenciamentoDeProdutos.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long codProduto;

	@Basic(optional = false)
	@Column(name = "nomeProduto")
	private String nomeProduto;

	@Basic(optional = false)
	@Column(name = "valorProduto")
	private Double valorProduto;
	
	@Basic(optional = false)
	@Column(name = "estoque")
	private Integer estoque;
	
	@ManyToOne
	@JoinColumn(name = "Produto_cidade")
	private Cidades cidade;




	public Produto(Long codProduto, String nomeProduto, Double valorProduto, Integer estoque, Cidades cidades) {
		super();
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.estoque = estoque;
		this.cidade = cidades;
	}

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public Cidades getCidades() {
		return cidade;
	}

	public void setCidades(Cidades cidades) {
		this.cidade = cidades;
	}

	public Produto() {
	}

	

}
