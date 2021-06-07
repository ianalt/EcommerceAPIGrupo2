package com.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdutosPedidosID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "produto_id")
	Integer produtoId;

	@Column(name = "pedidos_id")
	Integer pedidosId;

}
