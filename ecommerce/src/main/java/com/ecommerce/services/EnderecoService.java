package com.ecommerce.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.ecommerce.entities.Endereco;
import com.ecommerce.repositories.EnderecoRepository;
import com.ecommerce.vo.DadosCEPVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	@Autowired
	public EnderecoRepository enderecoRepository;

	@Autowired
	public ClienteService clienteService;

	@Autowired
	public Validator validator;

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

	public boolean delete(Integer id) {
		if (id != null) {
			enderecoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	
	public Endereco save(Endereco endereco) throws Exception {

		Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
		
		if(!violations.isEmpty()){
			StringBuilder sb = new StringBuilder();
			for(ConstraintViolation<Endereco> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			
			throw new ConstraintViolationException("Alguns campos precisam ser reavaliados: "+sb.toString(),violations);
		}

		DadosCEPVO dadosCEP = clienteService.consultarDadosPorCEP(endereco.getCep());

		endereco.setBairro(dadosCEP.getBairro());
		endereco.setCidade(dadosCEP.getLocalidade());
		endereco.setEstado(dadosCEP.getUf());
		endereco.setRua(dadosCEP.getLogradouro());

		if(dadosCEP.getCep() == null){
			throw new Exception("O CEP digitado é invalido");
		}
		Endereco novoEndereco = enderecoRepository.save(endereco);
		if (novoEndereco.getIdEndereco() != null) {
			return novoEndereco;
		} else {
			return null;
		}
	}

	public Endereco update(Endereco endereco, Integer id) throws Exception {

		Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
		
		if(!violations.isEmpty()){
			StringBuilder sb = new StringBuilder();
			for(ConstraintViolation<Endereco> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage() + " | ");
			}
			
			throw new ConstraintViolationException("Alguns campos precisam ser reavaliados: "+sb.toString(),violations);
		}

		endereco.setIdEndereco(id);
		DadosCEPVO dadosCEP = clienteService.consultarDadosPorCEP(endereco.getCep());

		if(dadosCEP.getCep() == null) {
			throw new Exception("O CEP digitado é invalido");	
		}
			endereco.setBairro(dadosCEP.getBairro());
			endereco.setCidade(dadosCEP.getLocalidade());
			endereco.setEstado(dadosCEP.getUf());
			endereco.setRua(dadosCEP.getLogradouro());
				
			return enderecoRepository.save(endereco);
		
		
		
		
		
	}
}
