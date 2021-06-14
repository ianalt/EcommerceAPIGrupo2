
package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Produto;
import com.ecommerce.repositories.ProdutoRepository;
//import com.ecommerce.repositories.ProdutosPedidosRepository;

@Service
public class ProdutoService {
	@Autowired
	public ProdutoRepository produtoRepository;

	public Produto findById(Integer id) {
		Produto produto = produtoRepository.findById(id).get();
		return produto;
	}

	public Produto findByNome(String nome) {
		Produto produto = produtoRepository.findByNome(nome);
		return produto;
	}

	public List<Produto> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Produto> listaProduto = null;
		List<Produto> listaProdutoComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listaProdutoComPaginacao = produtoRepository.findAll(page).getContent();

				return listaProdutoComPaginacao;
			} else {
				listaProduto = produtoRepository.findAll();

				return listaProduto;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de produtos :: " + e.getMessage());
		}
	}

	public Long count() {
		Long totalProdutos = produtoRepository.count();
		return totalProdutos;
	}

	public Produto save(Produto produto) {
		Produto novoProduto = produtoRepository.save(produto);
		if (novoProduto.getIdProduto() != null) {
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
		produto.setIdProduto(id);
		return produtoRepository.save(produto);
	}
}
