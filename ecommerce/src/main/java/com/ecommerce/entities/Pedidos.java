package com.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedidos")
	private Integer idPedidos;

	@Column(name = "numeropedido")
	private Integer numeroPedido;

	@Column(name = "totalpedido")
	private BigDecimal totalPedido;

	@Column(name = "datapedido")
	private Calendar dataPedido;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;

	// essa é a lista?
	@OneToMany(mappedBy = "pedidosId")
	private Set<ProdutosPedidos> setProdutosPedidos = new HashSet<>();

	public Integer getId() {
		return idPedidos;
	}

	public void setId(Integer id) {
		this.idPedidos = id;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getClient() {
		return cliente;
	}

	public void setClient(Cliente client) {
		this.cliente = client;
	}

	public Set<ProdutosPedidos> getSetProdutosPedidos() {
		return setProdutosPedidos;
	}

	public void setSetProdutosPedidos(Set<ProdutosPedidos> setProdutosPedidos) {
		this.setProdutosPedidos = setProdutosPedidos;
	}

}
