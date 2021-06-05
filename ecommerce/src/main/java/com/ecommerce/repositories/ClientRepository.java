package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
