package com.ecommerce.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "produtospedidos")
public class ProdutosPedidos {

	@EmbeddedId
	ProdutosPedidosID produtosPedidosId;

	@ManyToOne
	@MapsId("produtoId")
	@JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
	private Produto produtoId;

	@ManyToOne
	@MapsId("pedidosId")
	@JoinColumn(name = "pedidosId", referencedColumnName = "pedidosId")
	private Pedidos pedidosId;

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

}
