package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.Cliente;
// import com.ecommerce.entities.Cliente;
import com.ecommerce.entities.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

    List<Pedidos> findByCliente(Cliente cliente);

}
