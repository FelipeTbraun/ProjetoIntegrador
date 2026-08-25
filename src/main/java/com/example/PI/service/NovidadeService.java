package com.example.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI.model.Novidade;
import com.example.PI.repository.NovidadeRepository;

@Service
public class NovidadeService {

    @Autowired
    private NovidadeRepository repository;

    public Novidade criar(Novidade novidade) {
        novidade.setDataPublicacao(Novidade.hoje());
        return repository.save(novidade);
    }

    public List<Novidade> listar() {
        return repository.findAllByOrderByDataPublicacaoDesc();
    }

    public void deletar(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Novidade não encontrada");
        }
        repository.deleteById(id);
    }
}
