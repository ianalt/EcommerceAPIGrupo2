package com.ecommerce.services;

import java.util.List;

import javax.mail.MessagingException;

import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.Pedidos;
import com.ecommerce.entities.ProdutosPedidos;
import com.ecommerce.exception.EmailException;
import com.ecommerce.repositories.PedidosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	@Autowired
	public PedidosRepository pedidosRepository;

	@Autowired
	public EmailService emailService;

	public Pedidos findById(Integer id) {
		Pedidos pedido = pedidosRepository.findById(id).get();
		return pedido;
	}

	public List<Pedidos> findByCliente(Cliente cliente) {
		List<Pedidos> listPedidos = pedidosRepository.findByCliente(cliente);
		return listPedidos;

	}

	public List<Pedidos> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Pedidos> listaPedidos = null;
		List<Pedidos> listaPedidosComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listaPedidosComPaginacao = pedidosRepository.findAll(page).getContent();

				return listaPedidosComPaginacao;
			} else {
				listaPedidos = pedidosRepository.findAll();

				return listaPedidos;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos :: " + e.getMessage());
		}

	}

	public Long count() {
		Long totalPedidoss = pedidosRepository.count();
		return totalPedidoss;
	}

	public Pedidos save(Pedidos pedido) {
		Pedidos novoPedido = pedidosRepository.save(pedido);
		if (novoPedido.getIdPedidos() != null) {
			return novoPedido;
		} else {
			return null;
		}
	}

	public boolean delete(Integer id) {
		if (id != null) {
			pedidosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Pedidos update(Pedidos pedidos, Integer id) throws MessagingException, EmailException {

		Pedidos pedidosAtt = pedidosRepository.findById(id).get();

		if (pedidosAtt.getStatus().equalsIgnoreCase("aberto")) {
			pedidosAtt.setStatus(pedidos.getStatus());

			pedidosAtt.setTotalPedido(pedidos.getTotalPedido());
			pedidosAtt.setDataPedido(pedidos.getDataPedido());
			pedidosAtt.setNumeroPedido(pedidos.getNumeroPedido());
			// pedidosAtt.setCliente(pedidos.getCliente());	

			emailService.emailPedidos(pedidos);
		} else {
			pedidosAtt.setStatus("fechado");

			// Adicionar o metodo de email
		}

		return pedidosRepository.save(pedidosAtt);
	}


	// public Pedidos emitirnf(Integer orderId){

    //     Orders order = ordersRepository.getById(orderId);
	// 	Pedidos pedidos = pedidosRepository.getById(orderId);



	// 	List <OrderLines> listOrderLines = order.getListOrderLines();
	// 	List <ProdutosPedidos> listPedidos = pedidos.getListProdutosPedidos();

    //     NotafiscalVO notafiscalVO = new NotafiscalVO();	

	// 	if(order.getCustomer() != null){
	// 		notafiscalVO.setName(order.getCustomer().getFirstName());
	// 		notafiscalVO.setLastName(order.getCustomer().getLastName());
	// 	}else{
	// 		notafiscalVO.setName(null);
	// 		notafiscalVO.setLastName(null);
	// 	}


    //     notafiscalVO.setNetAmount(order.getNetAmount());
    //     notafiscalVO.setTotalAmount(order.getTotalAmount());
    //     notafiscalVO.setOrderDate(order.getOrderDate());
    //     notafiscalVO.setOrderId(order.getOrderId());
	

	// 	List<ItemOrderLinesVO> listItemOrderLinesVO = new ArrayList<>();
	// 	for(OrderLines orderlines : listOrderLines) {
	// 		ItemOrderLinesVO itemOrderLinesVO = new ItemOrderLinesVO();

	// 		Products product = productsRepository.findById(orderlines.getProdId()).get();

	// 		itemOrderLinesVO.setTitle(product.getTitle());
	// 		itemOrderLinesVO.setProdId(orderlines.getProdId());
	// 		itemOrderLinesVO.setQuantity(orderlines.getQuantity());
	// 		listItemOrderLinesVO.add(itemOrderLinesVO);
	// 	}

	// 	notafiscalVO.setListItemOrderLinesVO(listItemOrderLinesVO);

    //     return notafiscalVO;

    // }
}
