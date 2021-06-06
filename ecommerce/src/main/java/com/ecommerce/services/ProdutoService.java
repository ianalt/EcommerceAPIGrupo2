package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Produto;
import com.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	public ProdutoRepository produtoRepository;

	public Produto findById(Integer id) {
		Produto produto = produtoRepository.findById(id).get();
		return produto;
	}

	public List<Produto> findAll() {
		List<Produto> listaProduto = produtoRepository.findAll();
		return listaProduto;
	}

	public Long count() {
		Long totalProdutos = produtoRepository.count();
		return totalProdutos;
	}

	public Produto save(Produto produto) {
		Produto novoProduto = produtoRepository.save(produto);
		if (novoProduto.getId() != null) {
			return novoProduto;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			produtoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Produto update(Produto produto, Integer id) {
		produto.setId(id);
		return produtoRepository.save(produto);
	}
}
