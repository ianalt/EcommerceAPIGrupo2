package com.ecommerce.services;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.Endereco;
import com.ecommerce.repositories.ClienteRepository;
import com.ecommerce.repositories.EnderecoRepository;
import com.ecommerce.vo.DadosCEPVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ClienteService implements Serializable{
	@Autowired
	public ClienteRepository clienteRepository;
	
	@Autowired
	public EnderecoService enderecoService;

	@Autowired
	public EnderecoRepository enderecoRepository;

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

		
		if(consultarDadosPorCEP(cliente.getEndereco().getCep()).getCep() != null){
			
			Endereco novoEndereco = enderecoRepository.save(cliente.getEndereco());
			
			DadosCEPVO cepVO = consultarDadosPorCEP(cliente.getEndereco().getCep());

			System.out.println(consultarDadosPorCEP(cliente.getEndereco().getCep()) + "marcado");

			novoEndereco.setBairro(cepVO.getBairro());
			novoEndereco.setCep(cepVO.getCep());
			novoEndereco.setCidade(cepVO.getLocalidade());
			novoEndereco.setEstado(cepVO.getUf());
			novoEndereco.setComplemento(cepVO.getComplemento());
			novoEndereco.setNumero(cliente.getEndereco().getNumero());
			novoEndereco.setRua(cepVO.getLogradouro());
			
		
			Cliente novoCliente = clienteRepository.save(cliente);
		
			if (novoCliente.getIdCliente() != null) {

					novoCliente.setEndereco(novoEndereco);
					return novoCliente;

				}else{
					return null;
				}

		} else {
				return null;
		}
	}

	public Endereco retornaCEP(Cliente cliente){
		
		boolean igual = false;

		DadosCEPVO cepVO = consultarDadosPorCEP(cliente.getEndereco().getCep());
		
		for(Endereco clientelist : enderecoRepository.findAll()){
			if(clientelist.getCep() == cliente.getEndereco().getCep()){
				igual = true;
			}
		}
		if(igual == true){
			return cliente.getEndereco();
		} else{
			Endereco novoEndereco = enderecoRepository.save(cliente.getEndereco());

			novoEndereco.setBairro(cepVO.getBairro());
			novoEndereco.setCep(cepVO.getCep());
			novoEndereco.setCidade(cepVO.getLocalidade());
			novoEndereco.setEstado(cepVO.getUf());
			novoEndereco.setComplemento(cepVO.getComplemento());
			novoEndereco.setNumero(cliente.getEndereco().getNumero());
			novoEndereco.setRua(cepVO.getLogradouro());

			return novoEndereco;
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
		
		Cliente clienteAtt =  clienteRepository.findById(id).get();

		clienteAtt.setDataNascimento(cliente.getDataNascimento());
		clienteAtt.setEmail(cliente.getEmail());
		clienteAtt.setNome(cliente.getNome());
		clienteAtt.setSenha(cliente.getSenha());
		clienteAtt.setTelefone(cliente.getTelefone());
		clienteAtt.setUsername(cliente.getUsername());
		clienteAtt.setEndereco(enderecoService.update(cliente.getEndereco(),id));

	return clienteRepository.save(clienteAtt);
}
	
//	public ClienteVO updateVO(ClienteVO clienteVO, Integer id) {
//		clienteVO.setIdCliente(id);
//		return clienteRepository.save(clienteVO);
//	}

	public DadosCEPVO consultarDadosPorCEP(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json";	
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);
			
		DadosCEPVO dadosCEPVO = restTemplate.getForObject(uri, DadosCEPVO.class, params);
			
		return dadosCEPVO;
	}

	// public ReceitaWsDadosCnpjVO consultarDadosPorCnpj(String cnpj) {
	// 	RestTemplate restTemplate = new RestTemplate();
	// 	String uri = "https://www.receitaws.com.br/v1/cnpj/{cnpj}";	
	// 	Map<String, String> params = new HashMap<String, String>();
	// 	params.put("cnpj", cnpj);
			
	// 	ReceitaWsDadosCnpjVO receitaWsDadosCnpjVO = restTemplate.getForObject(uri, ReceitaWsDadosCnpjVO.class, params);
			
	// 	return receitaWsDadosCnpjVO;
	//   }

}
