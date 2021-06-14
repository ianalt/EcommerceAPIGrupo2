package com.ecommerce.controllers;

import javax.validation.Valid;

import com.ecommerce.entities.Cliente;
import com.ecommerce.services.ClienteService;
import com.ecommerce.vo.DadosCEPVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	// findById
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(clienteService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/cep/{cep}")
	public ResponseEntity<DadosCEPVO> DadosCEPVO(@PathVariable String cep){
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(clienteService.consultarDadosPorCEP(cep), headers, HttpStatus.OK);
	}

	// @GetMapping("/cnpj/{cnpj}")
	// public ResponseEntity<ReceitaWsDadosCnpjVO> consultarDadosPorCnpj(@PathVariable String cnpj){
	// 	HttpHeaders headers = new HttpHeaders();

	// 	return new ResponseEntity<>(clienteService.consultarDadosPorCnpj(cnpj), headers, HttpStatus.OK);
	// }

	// findByUsernameAndSenha
	@GetMapping("/{username}/{senha}")
	public ResponseEntity<String> verificaLogin(@Valid @PathVariable String username,@PathVariable String senha) {
		HttpHeaders headers = new HttpHeaders();

		String respostaLogin = clienteService.verificaLogin(username, senha);

		if (null != respostaLogin) {
			return new ResponseEntity<>(respostaLogin, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(respostaLogin, headers, HttpStatus.BAD_REQUEST);
		}

	}

	// save
	@PostMapping
	public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Cliente novoCliente = clienteService.save(cliente);

		if (novoCliente != null) {
			return new ResponseEntity<>(novoCliente, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoCliente, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = clienteService.delete(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente, @PathVariable Integer id) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Cliente clienteAtualizado = clienteService.update(cliente, id);

		if (clienteAtualizado != null) {
			return new ResponseEntity<>(clienteAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(clienteAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
