package com.example.PI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PI.model.Formulario;

public interface FormularioRepository extends MongoRepository<Formulario, String > {

}
