package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Categoria findByNome(String nome) {
		Categoria categoria = categoriaRepository.findByNome(nome);
		return categoria;
	}

	public List<Categoria> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Categoria> listCategoria = null;
		List<Categoria> listCategoriaComPaginacao = null;

		try {
			if (pagina != null && qtdRegistros != null) {
				page = PageRequest.of(pagina, qtdRegistros);
				listCategoriaComPaginacao = categoriaRepository.findAll(page).getContent();

				return listCategoriaComPaginacao;
			} else {
				listCategoria = categoriaRepository.findAll();

				return listCategoria;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de categorias :: " + e.getMessage());
		}

	}

	public Long count() {
		Long totalCategorias = categoriaRepository.count();
		return totalCategorias;
	}

	public Categoria save(Categoria categoria) {
		Categoria novaCategoria = categoriaRepository.save(categoria);
		if (novaCategoria.getIdCategoria() != null) {
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
		categoria.setIdCategoria(id);
		return categoriaRepository.save(categoria);
	}
}
