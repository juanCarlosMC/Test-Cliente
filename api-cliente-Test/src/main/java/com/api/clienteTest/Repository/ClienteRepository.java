package com.api.clienteTest.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.clienteTest.Documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer>{

}
