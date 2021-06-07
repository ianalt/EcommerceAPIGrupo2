package com.ecommerce.entities;



import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.websocket.ClientEndpoint;

@Entity
@Table(name = "produtospedidos")
public class ProdutosPedidos {

	//No diagrama ele tem uma chave primária
	// @Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	// private Integer id_produtosPedidos;

	@EmbeddedId
	ProdutosPedidosID produtosPedidosId;

	@ManyToOne
	@MapsId("produtoId")
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private Produto produtoId;

	@ManyToOne
	@MapsId("pedidosId")
	@JoinColumn(name = "id_pedidos", referencedColumnName = "id_pedidos")
	private Pedidos pedidosId;


	//Verificar isso tbm
	// @Column(name = "quantidade")
	// private Integer quantidade;

	// @Column(name = "preco")
	// private BigDecimal preco;

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
