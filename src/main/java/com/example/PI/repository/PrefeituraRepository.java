package com.example.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PI.model.Prefeitura;


public interface PrefeituraRepository extends JpaRepository<Prefeitura, String>{
    
}
