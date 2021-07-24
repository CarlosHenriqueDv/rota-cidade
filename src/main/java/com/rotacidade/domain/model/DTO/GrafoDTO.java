package com.rotacidade.domain.model.DTO;


import java.math.BigDecimal;


public class GrafoDTO {

    private String origem;
    private String destino;
    private BigDecimal distancia;

    public GrafoDTO(String origem, String destino, BigDecimal distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }


    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }
}
