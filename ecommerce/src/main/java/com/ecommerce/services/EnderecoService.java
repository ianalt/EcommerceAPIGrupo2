package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Endereco;
import com.ecommerce.repositories.EnderecoRepository;
import com.ecommerce.vo.DadosCEPVO;

@Service
public class EnderecoService {
	@Autowired
	public EnderecoRepository enderecoRepository;

	@Autowired
	public ClienteService clienteService;

	public Endereco findById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id).get();
		return endereco;
	}

	public List<Endereco> findAll() {
		List<Endereco> listaEndereco = enderecoRepository.findAll();
		return listaEndereco;
	}

	public Long count() {
		Long totalEnderecos = enderecoRepository.count();
		return totalEnderecos;
	}

	public Endereco save(Endereco endereco) {
		Endereco novoEndereco = enderecoRepository.save(endereco);
		if (novoEndereco.getIdEndereco() != null) {
			return novoEndereco;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			enderecoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Endereco update(Endereco endereco, Integer id) {
		endereco.setIdEndereco(id);
		DadosCEPVO dadosCEP = clienteService.consultarDadosPorCEP(endereco.getCep());

		endereco.setBairro(dadosCEP.getBairro());
		endereco.setCidade(dadosCEP.getLocalidade());
		endereco.setEstado(dadosCEP.getUf());
		endereco.setRua(dadosCEP.getLogradouro());

		return enderecoRepository.save(endereco);
	}
}
