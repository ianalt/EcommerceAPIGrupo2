package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Cliente;
import com.ecommerce.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	public ClienteRepository clienteRepository;

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
}
