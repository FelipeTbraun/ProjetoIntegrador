package com.example.PI.dto;

import com.example.PI.model.StatusFormulario;

public class StatusUpdate {

    private StatusFormulario status;
    private String resposta;

    public StatusFormulario getStatus() {
        return status;
    }

    public void setStatus(StatusFormulario status) {
        this.status = status;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
