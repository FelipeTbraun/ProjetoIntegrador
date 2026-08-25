package com.example.PI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PI.model.Novidade;

public interface NovidadeRepository extends MongoRepository<Novidade, String> {

    List<Novidade> findAllByOrderByDataPublicacaoDesc();

}
