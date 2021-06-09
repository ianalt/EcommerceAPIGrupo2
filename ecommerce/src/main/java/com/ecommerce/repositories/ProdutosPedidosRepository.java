package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.ProdutosPedidos;

@Repository
public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos, Integer> {

}
