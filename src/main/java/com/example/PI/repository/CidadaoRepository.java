package com.example.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PI.model.Cidadao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

    Cidadao findByEmail(String email);
    Cidadao findByCpf(String cpf);

}
