package com.ecommerce.controllers;

import java.util.List;

import javax.mail.MessagingException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.Pedidos;
import com.ecommerce.exception.EmailException;
//import com.ecommerce.services.EmailService;
import com.ecommerce.services.PedidosService;
//import com.ecommerce.services.ProdutosPedidosService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	@Autowired
	private PedidosService pedidosService;
	
//	@Autowired
//	private ProdutosPedidosService produtosPedidosService;

//	@Autowired
//	private EmailService emailService;

	// findById
	// @GetMapping("/{id}")
	// public ResponseEntity<Pedidos> findById(@PathVariable Integer id) {
	// 	HttpHeaders headers = new HttpHeaders();

	// 	return new ResponseEntity<>(pedidosService.findById(id), headers, HttpStatus.OK);
	// }

	@GetMapping("/cliente/{cliente}")
	public ResponseEntity <List<Pedidos>> findByCliente(@PathVariable Cliente cliente){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(pedidosService.findByCliente(cliente), headers, HttpStatus.OK);
	}

	// findAll
	@GetMapping
	public ResponseEntity<List<Pedidos>> findAll(@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(pedidosService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
	}

	// count
	@GetMapping("/count")
	public Long count() {
		return pedidosService.count();
	}

	// save
	@PostMapping
	public ResponseEntity<Pedidos> save(@RequestBody Pedidos pedido) {
		HttpHeaders headers = new HttpHeaders();

		Pedidos novoPedido = pedidosService.save(pedido);

		if (novoPedido != null) {
			return new ResponseEntity<>(novoPedido, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoPedido, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Pedidos> delete(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = pedidosService.delete(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Pedidos> update(@RequestBody Pedidos pedido, @PathVariable Integer id) throws MessagingException, EmailException {
		HttpHeaders headers = new HttpHeaders();

		Pedidos pedidoAtualizado = pedidosService.update(pedido, id);
		
//		produtosPedidosService.updateByPedidosId(pedidoAtualizado.getListProdutosPedidos(), pedidoAtualizado.getIdPedidos());
		


		if (pedidoAtualizado != null) {
			return new ResponseEntity<>(pedidoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pedidoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
