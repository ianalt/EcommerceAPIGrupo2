package com.ecommerce.services;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.entities.Cliente;
import com.ecommerce.repositories.ClienteRepository;
import com.ecommerce.repositories.EnderecoRepository;
import com.ecommerce.vo.DadosCEPVO;



@Service
public class ClienteService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public String verificaLogin(String username, String senha) {
		Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
		
		if(cliente != null) {
			return "Usuário logado com sucesso!";
		} else {
			return "Nome de usuário e/ou senha incorretos!";
		}
		

	}

	public Cliente save(Cliente cliente) throws Exception {

		enderecoService.save(cliente.getEndereco());

		return clienteRepository.save(cliente);
	}

	public boolean delete(Integer id) {
		if (id != null) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Cliente update(Cliente cliente, Integer id) throws Exception {	
		
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
