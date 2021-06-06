package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Pedidos;
import com.ecommerce.repositories.PedidosRepository;

@Service
public class PedidosService {
	@Autowired
	public PedidosRepository pedidosRepository;

	public Pedidos findById(Integer id) {
		Pedidos pedidos = pedidosRepository.findById(id).get();
		return pedidos;
	}

	public List<Pedidos> findAll() {
		List<Pedidos> listaPedidos = pedidosRepository.findAll();
		return listaPedidos;
	}

	public Long count() {
		Long totalPedidoss = pedidosRepository.count();
		return totalPedidoss;
	}

	public Pedidos save(Pedidos pedido) {
		Pedidos novoPedido = pedidosRepository.save(pedido);
		if (novoPedido.getId() != null) {
			return novoPedido;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			pedidosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Pedidos update(Pedidos pedido, Integer id) {
		pedido.setId(id);
		return pedidosRepository.save(pedido);
	}
}
