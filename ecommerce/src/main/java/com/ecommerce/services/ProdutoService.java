
package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Produto;
import com.ecommerce.entities.ProdutosPedidos;
import com.ecommerce.repositories.ProdutoRepository;
import com.ecommerce.vo.ProdutoVO;
import com.ecommerce.vo.ProdutosPedidosVO;

@Service
public class ProdutoService {
	@Autowired
	public ProdutoRepository produtoRepository;

//	public ProdutoVO convertEntidadeParaVO(Produto produto) {
//		ProdutoVO produtoVO = new ProdutoVO();
//		List<ProdutosPedidosVO> listProdutosPedidosVO = new ArrayList<>();
//
//		produtoVO.setIdProduto(produto.getIdProduto());
//		produtoVO.setNome(produto.getNome());
//		produtoVO.setDescricao(produto.getDescricao());
//		produtoVO.setPreco(produto.getPreco());
//		produtoVO.setQtdEstoque(produto.getQtdEstoque());
//		produtoVO.setDataCadastro(produto.getDataCadastro());
//		produtoVO.setImagem(produto.getImagem());
//		produtoVO.setCategoria(produto.getCategoria());
//
//		List<ProdutosPedidos> listProdutosPedidos = produto.getListProdutosPedidos();
//
//		if (listProdutosPedidos != null) {
//			for (ProdutosPedidos itemProdPed : listProdutosPedidos) {
//				ProdutosPedidosVO prodPedVO = new ProdutosPedidosVO();
//
//				prodPedVO.setIdProdutosPedidos(itemProdPed.getIdProdutosPedidos());
//				prodPedVO.setPedidosId(itemProdPed.getPedidosId());
//				prodPedVO.setPreco(itemProdPed.getPreco());
//				prodPedVO.setProdutoId(itemProdPed.getProdutoId());
//				prodPedVO.setQuantidade(itemProdPed.getQuantidade());
//
//				listProdutosPedidosVO.add(prodPedVO);
//
//			}
//
//			produtoVO.setListProdutosPedidosVO(listProdutosPedidosVO);
//
//		} else {
//			produtoVO.setListProdutosPedidosVO(null);
//
//		}
//		return produtoVO;
//
//	}

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

//	public List<ProdutoVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
//		Pageable page = null;
//		List<Produto> listProduto = null;
//		List<Produto> listProdutoComPaginacao = null;
//		List<ProdutoVO> listProdutoVO = new ArrayList<>();
//
//		try {
//			if (null != pagina && null != qtdRegistros) {
//				page = PageRequest.of(pagina, qtdRegistros);
//				listProdutoComPaginacao = produtoRepository.findAll(page).getContent();
//
//				for (Produto itemProduto : listProdutoComPaginacao) {
//					listProdutoVO.add(convertEntidadeParaVO(itemProduto));
//				}
//			} else {
//				listProduto = produtoRepository.findAll();
//
//				for (Produto itemProduto : listProduto) {
//					listProdutoVO.add(convertEntidadeParaVO(itemProduto));
//				}
//			}
//		} catch (Exception e) {
//			throw new Exception("Não foi possível recuperar a lista de produtos :: " + e.getMessage());
//		}
//		return listProdutoVO;
//	}

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
