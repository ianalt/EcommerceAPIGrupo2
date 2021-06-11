package com.ecommerce.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.ProdutosPedidos;

public class PedidosVO {
	private Integer idPedidos;
	private Integer numeroPedido;
	private BigDecimal totalPedido;
	private Calendar dataPedido;
	private String status;
	private Cliente cliente;
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
