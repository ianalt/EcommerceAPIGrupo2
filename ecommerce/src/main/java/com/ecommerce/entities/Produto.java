package com.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer idProduto;

	@NotBlank(message = "O produto precisa possuir um nome")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "O produto precisa ter uma descrição")
	@Column(name = "descricao")
	private String descricao;

	@Min(value = 0, message = "O preço do produto não pode ser inferior a zero")
	@Column(name = "preco")
	private BigDecimal preco;

	@Min(value = 0, message = "A quantidade de produtos em estoque não pode ser inferior a zero")
	@Column(name = "qtdestoque")
	private Integer qtdEstoque;

	@Column(name = "datacadastro")
	private Calendar dataCadastro;

	@Column(name = "imagem")
	private String imagem;

	@ManyToOne
	@JsonDeserialize  // @JsonManagedReference
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;

	@JsonBackReference
	@OneToMany(mappedBy = "produtoId")
	private List<ProdutosPedidos> listProdutosPedidos;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ProdutosPedidos> getListProdutosPedidos() {
		return listProdutosPedidos;
	}

	public void setListProdutosPedidos(List<ProdutosPedidos> listProdutosPedidos) {
		this.listProdutosPedidos = listProdutosPedidos;
	}

}
