package com.rotacidade.domain.model.DTO;


import java.math.BigDecimal;


public class GrafoDTO {

    private Long idGrafo;
    private String origem;
    private String destino;
    private BigDecimal distancia;

    public GrafoDTO(Long idGrafo, String origem, String destino, BigDecimal distancia) {
        this.idGrafo = idGrafo;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Long getIdGrafo() {
        return idGrafo;
    }

    public void setIdGrafo(Long idGrafo) {
        this.idGrafo = idGrafo;
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
}
