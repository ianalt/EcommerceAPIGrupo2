package com.ecommerce.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "produtospedidos")
public class ProdutosPedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProdutosPedidos;

	@ManyToOne
	@JsonDeserialize  // @JsonManagedReference
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private Produto produtoId;

	@ManyToOne
	@JsonDeserialize  // @JsonManagedReference
	@JoinColumn(name = "id_pedidos", referencedColumnName = "id_pedidos")
	private Pedidos pedidosId;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
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
