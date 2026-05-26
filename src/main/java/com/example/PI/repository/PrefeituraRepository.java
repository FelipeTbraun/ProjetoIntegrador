package com.example.PI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.PI.model.Prefeitura;


public interface PrefeituraRepository extends MongoRepository<Prefeitura, String>{

}
