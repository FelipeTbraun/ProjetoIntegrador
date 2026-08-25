package com.example.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI.model.Formulario;
import com.example.PI.model.StatusFormulario;
import com.example.PI.repository.FormularioRepository;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository repository;

    public Formulario criar(Formulario f){
        f.setStatus(StatusFormulario.EM_ANALISE);
        return repository.save(f);
    }
    public List<Formulario> listar(){
        return repository.findAll();
    }

    public Formulario buscarPorId(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Formulario não encontrado"));
    }

    public List<Formulario> listarPorCidadao(String cidadaoId){
        return repository.findByCidadaoId(cidadaoId);
    }

    public Formulario atualizarStatus(String id, StatusFormulario status, String resposta){
        Formulario formulario = buscarPorId(id);
        formulario.setStatus(status);
        formulario.setResposta(resposta);
        return repository.save(formulario);
    }

    public void deletar(String id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Formulário não encontrado");
        }
       repository.deleteById(id);
    }
}
