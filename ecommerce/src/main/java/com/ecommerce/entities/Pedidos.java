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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
	@JsonDeserialize  // @JsonManagedReference //problemas com ele 
	private Cliente cliente;

	// essa é a lista?
	@OneToMany(mappedBy = "pedidosId")
	@JsonBackReference
	private List<ProdutosPedidos> listProdutosPedidos;

	public Integer getIdPedidos() {
		return idPedidos;
	}

	public void setIdPedidos(Integer idPedidos) {
		this.idPedidos = idPedidos;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ProdutosPedidos> getListProdutosPedidos() {
		return listProdutosPedidos;
	}

	public void setListProdutosPedidos(List<ProdutosPedidos> listProdutosPedidos) {
		this.listProdutosPedidos = listProdutosPedidos;
	}

}
