package com.ecommerce.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import com.ecommerce.entities.Categoria;

public class ProdutoVO {
	private Integer idProduto;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer qtdEstoque;
	private Calendar dataCadastro;
	private String imagem;
	private Categoria categoria;
	private List<ProdutosPedidosVO> listProdutosPedidosVO;

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

	public List<ProdutosPedidosVO> getListProdutosPedidosVO() {
		return listProdutosPedidosVO;
	}

	public void setListProdutosPedidosVO(List<ProdutosPedidosVO> listProdutosPedidosVO) {
		this.listProdutosPedidosVO = listProdutosPedidosVO;
	}

}
