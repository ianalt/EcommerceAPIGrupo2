package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Cliente;
import com.ecommerce.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	public ClientRepository clientRepository;

	public Cliente findById(Integer id) {
		Cliente client = clientRepository.findById(id).get();
		return client;
	}

	public List<Cliente> findAll() {
		List<Cliente> listaClient = clientRepository.findAll();
		return listaClient;
	}

	public Long count() {
		Long totalClients = clientRepository.count();
		return totalClients;
	}

	public Cliente save(Cliente client) {
		Cliente novoClient = clientRepository.save(client);
		if (novoClient.getId() != null) {
			return novoClient;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			clientRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Cliente update(Cliente client, Integer id) {
		client.setId(id);
		return clientRepository.save(client);
	}
}
