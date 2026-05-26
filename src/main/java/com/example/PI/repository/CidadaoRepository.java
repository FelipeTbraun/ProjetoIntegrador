package com.example.PI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PI.model.Cidadao;

public interface CidadaoRepository extends MongoRepository<Cidadao, String> {

    Cidadao findByEmail(String email);

    Cidadao findByCpf(String cpf);

}
