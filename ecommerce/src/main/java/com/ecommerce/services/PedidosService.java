package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.Pedidos;
import com.ecommerce.repositories.PedidosRepository;

@Service
public class PedidosService {
	@Autowired
	public PedidosRepository pedidosRepository;

	public Pedidos findById(Integer id) {
		Pedidos pedido = pedidosRepository.findById(id).get();
		return pedido;
	}


	public Pedidos findByCliente(Cliente cliente){
		Pedidos pedido = pedidosRepository.findByCliente(cliente);
		return pedido;

	}

	public List<Pedidos> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Pedidos> listaPedidos = null;
		List<Pedidos> listaPedidosComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listaPedidosComPaginacao = pedidosRepository.findAll(page).getContent();

				return listaPedidosComPaginacao;
			} else {
				listaPedidos = pedidosRepository.findAll();

				return listaPedidos;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos :: " + e.getMessage());
		}

	}

	public Long count() {
		Long totalPedidoss = pedidosRepository.count();
		return totalPedidoss;
	}

	public Pedidos save(Pedidos pedido) {
		Pedidos novoPedido = pedidosRepository.save(pedido);
		if (novoPedido.getIdPedidos() != null) {
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
		pedido.setIdPedidos(id);
		return pedidosRepository.save(pedido);
	}
}
