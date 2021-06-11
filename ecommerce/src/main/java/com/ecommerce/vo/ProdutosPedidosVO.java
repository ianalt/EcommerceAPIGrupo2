package com.ecommerce.vo;

import java.math.BigDecimal;

import com.ecommerce.entities.Pedidos;
import com.ecommerce.entities.Produto;

public class ProdutosPedidosVO {
	private Integer idProdutosPedidos;
	private Produto produtoId;
	private Pedidos pedidosId;
	private Integer quantidade;
	private BigDecimal preco;

	public Integer getIdProdutosPedidos() {
		return idProdutosPedidos;
	}

	public void setIdProdutosPedidos(Integer idProdutosPedidos) {
		this.idProdutosPedidos = idProdutosPedidos;
	}

	public Produto getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}

	public Pedidos getPedidosId() {
		return pedidosId;
	}

	public void setPedidosId(Pedidos pedidosId) {
		this.pedidosId = pedidosId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
