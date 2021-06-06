package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Client;
import com.ecommerce.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	public ClientRepository clientRepository;

	public Client findById(Integer id) {
		Client client = clientRepository.findById(id).get();
		return client;
	}

	public List<Client> findAll() {
		List<Client> listaClient = clientRepository.findAll();
		return listaClient;
	}

	public Long count() {
		Long totalClients = clientRepository.count();
		return totalClients;
	}

	public Client save(Client client) {
		Client novoClient = clientRepository.save(client);
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

	public Client update(Client client, Integer id) {
		client.setId(id);
		return clientRepository.save(client);
	}
}
