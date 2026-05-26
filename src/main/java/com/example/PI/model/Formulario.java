package com.example.PI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formularios")
public class Formulario {

    @Id
    private String id;

    private Categoria categoria;

    private TipoSolicitacao motivo;

    private String endereco;
    private String dataOcorrido;
    private String anexo;
    private String status;

    private Cidadao cidadao;

    public Formulario() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoSolicitacao getMotivo() {
        return motivo;
    }

    public void setMotivo(TipoSolicitacao motivo) {
        this.motivo = motivo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(String dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }
}
