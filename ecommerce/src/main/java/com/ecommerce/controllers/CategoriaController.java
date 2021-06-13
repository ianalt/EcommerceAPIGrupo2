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

import com.ecommerce.entities.Categoria;
import com.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	// findById
	// @GetMapping("/{id}")
	// public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
	// 	HttpHeaders headers = new HttpHeaders();

	// 	return new ResponseEntity<>(categoriaService.findById(id), headers, HttpStatus.OK);
	// }

	// findByNome
	@GetMapping("/{nome}")
	public ResponseEntity<Categoria> findByNome(@PathVariable String nome) {
		HttpHeaders headers = new HttpHeaders();

		Categoria categoria = categoriaService.findByNome(nome);

		if (null != categoria) {
			return new ResponseEntity<>(categoria, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(categoria, headers, HttpStatus.BAD_REQUEST);
		}

	}

	// findAll
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<>(categoriaService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
	}

	// count
	@GetMapping("/count")
	public Long count() {
		return categoriaService.count();
	}

	// save
	@PostMapping
	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {
		HttpHeaders headers = new HttpHeaders();

		Categoria novaCategoria = categoriaService.save(categoria);

		if (novaCategoria != null) {
			return new ResponseEntity<>(novaCategoria, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novaCategoria, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> delete(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = categoriaService.delete(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@Valid @RequestBody Categoria categoria, @PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		Categoria categoriaAtualizada = categoriaService.update(categoria, id);

		if (categoriaAtualizada != null) {
			return new ResponseEntity<>(categoriaAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(categoriaAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
