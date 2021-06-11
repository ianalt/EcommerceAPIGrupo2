package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.Pedidos;
import com.ecommerce.repositories.ClienteRepository;
import com.ecommerce.vo.ClienteVO;
import com.ecommerce.vo.PedidosVO;

@Service
public class ClienteService {
	@Autowired
	public ClienteRepository clienteRepository;
	
	
//	public ClienteVO convertEntidadeParaVO(Cliente cliente) {
//		
//		ClienteVO clienteVO = new ClienteVO();
//		List<PedidosVO> listPedidosVO = new ArrayList<>();
//		
//		clienteVO.setCpf(cliente.getCpf());
//		clienteVO.setDataNascimento(cliente.getDataNascimento());
//		clienteVO.setEmail(cliente.getEmail());
//		clienteVO.setEndereco(cliente.getEndereco());
//		clienteVO.setIdCliente(cliente.getIdCliente());
//		clienteVO.setIdCliente(cliente.getIdCliente());
//		clienteVO.setNome(cliente.getNome());
//		clienteVO.setSenha(cliente.getSenha());
//		clienteVO.setTelefone(cliente.getTelefone());
//		clienteVO.setUsername(cliente.getUsername());
//		
//		List<Pedidos> listPedidos = cliente.getListPedidos();
//		
//		if (listPedidos != null) {
//			for (Pedidos itemPed : listPedidos) {
//				PedidosVO pedVO = new PedidosVO();
//				
//				pedVO.setCliente(itemPed.getCliente());
//				pedVO.setDataPedido(itemPed.getDataPedido());
//				pedVO.setIdPedidos(itemPed.getIdPedidos());
//				pedVO.setListProdutosPedidos(itemPed.getListProdutosPedidos());
//				pedVO.setNumeroPedido(itemPed.getNumeroPedido());
//				pedVO.setStatus(itemPed.getStatus());
//				pedVO.setTotalPedido(itemPed.getTotalPedido());
//				
//				listPedidosVO.add(pedVO);
//			}
//			
//			clienteVO.setListPedidosVO(listPedidosVO);
//		
//		} else {
//			clienteVO.setListPedidosVO(null);
//		}
//		return clienteVO;
//	}

	public Cliente findById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).get();
		return cliente;
	}

	public Cliente findByUsernameAndSenha(String username, String senha) {
		Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
		return cliente;
	}

	public Cliente save(Cliente cliente) {
		Cliente novoCliente = clienteRepository.save(cliente);
		if (novoCliente.getIdCliente() != null) {
			return novoCliente;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Cliente update(Cliente cliente, Integer id) {
		cliente.setIdCliente(id);
		return clienteRepository.save(cliente);
	}
	
//	public ClienteVO updateVO(ClienteVO clienteVO, Integer id) {
//		clienteVO.setIdCliente(id);
//		return clienteRepository.save(clienteVO);
//	}

}
