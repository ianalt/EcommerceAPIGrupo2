package com.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.ecommerce.entities.Produto;
import com.ecommerce.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;

	// findByNome
	@GetMapping("/{nome}")
	public ResponseEntity<Produto> findByNome(@PathVariable String nome) {
		HttpHeaders headers = new HttpHeaders();

		Produto produto = produtoService.findByNome(nome);

		if (null != produto) {
			return new ResponseEntity<>(produto, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(produto, headers, HttpStatus.BAD_REQUEST);
		}

	}

	// findAll
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(produtoService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
	}

	// findAllVO
//	@GetMapping("/findAllVO")
//	public ResponseEntity<List<ProdutoVO>> findAllVO(@RequestParam(required = false) Integer pagina,
//			@RequestParam(required = false) Integer qtdRegistros) throws Exception {
//		HttpHeaders headers = new HttpHeaders();
//
//		return new ResponseEntity<>(produtoService.findAllVO(pagina, qtdRegistros), headers, HttpStatus.OK);
//	}

	// save
	@PostMapping
	public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
		HttpHeaders headers = new HttpHeaders();

		Produto novoProduto = produtoService.save(produto);

		if (novoProduto != null) {
			return new ResponseEntity<>(novoProduto, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoProduto, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> delete(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = produtoService.delete(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		Produto produtoAtualizado = produtoService.update(produto, id);

		if (produtoAtualizado != null) {
			return new ResponseEntity<>(produtoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(produtoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
