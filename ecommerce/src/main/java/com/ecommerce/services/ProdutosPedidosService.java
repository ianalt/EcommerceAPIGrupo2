//package com.ecommerce.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ecommerce.entities.Pedidos;
//import com.ecommerce.entities.ProdutosPedidos;
//import com.ecommerce.repositories.PedidosRepository;
//import com.ecommerce.repositories.ProdutoRepository;
//import com.ecommerce.repositories.ProdutosPedidosRepository;
//
//@Service
//public class ProdutosPedidosService {
//	@Autowired
//	public ProdutosPedidosRepository produtosPedidosRepository;
//	
//	@Autowired
//	public PedidosRepository pedidosRepository;
//	
//	@Autowired
//	public ProdutoRepository produtoRepository;
//	
//	public void updateByPedidosId(List<ProdutosPedidos> listProdutosPedidos, Integer pedidosId) {
////		produtosPedidos.setIdProdutosPedidos(id);
//		
//				
//		Pedidos pedido = pedidosRepository.getById(pedidosId);
////		
////		List<ProdutosPedidos> listProdPed = produtosPedidosRepository.findByPedidosId(pedidosId);
////		
////		List<ProdutosPedidos> listProdPedAtt = new ArrayList<>();
////		
////		
//		for (ProdutosPedidos itemProdPed : listProdutosPedidos) {
////			itemProdPed.setProdutoId(listProdPed.getProdutoId());
//			itemProdPed.setPedidosId(pedido);
////			itemProdPed.setPreco();
////			itemProdPed.setQuantidade(listProdPed.getQuantidade());
////			
////			listProdPedAtt.add(itemProdPed);
//			produtosPedidosRepository.save(itemProdPed);
//		}
////		
////		pedido.setListProdutosPedidos(listProdPedAtt);
//			
//	}
//	
//	
//	public ProdutosPedidos updateByProdutoId(ProdutosPedidos produtosPedidos, Integer produtoId) {
////		produtosPedidos.setIdProdutosPedidos(id);
//		
//		
//		
//		return produtosPedidosRepository.save(produtosPedidos);
//	}
//}
