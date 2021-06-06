package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Categoria;
import com.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		return categoria;
	}

	public List<Categoria> findAll() {
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		return listaCategoria;
	}

	public Long count() {
		Long totalCategorias = categoriaRepository.count();
		return totalCategorias;
	}

	public Categoria save(Categoria categoria) {
		Categoria novaCategoria = categoriaRepository.save(categoria);
		if (novaCategoria.getId() != null) {
			return novaCategoria;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			categoriaRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Categoria update(Categoria categoria, Integer id) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}
}
