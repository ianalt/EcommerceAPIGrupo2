package com.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdutosPedidosID {

	@Column(name = "produto_id")
	Integer produtoId;

	@Column(name = "pedidos_id")
	Integer pedidosId;

}
