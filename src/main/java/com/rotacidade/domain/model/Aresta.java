package com.rotacidade.domain.model;

import java.math.BigDecimal;

public class Aresta extends AbstractEntity<Long> {

    private Vertice inicio;

    private Vertice fim;

    private BigDecimal distancia;

    public Aresta(Vertice inicio, Vertice fim, BigDecimal distancia) {
        this.inicio = inicio;
        this.fim = fim;
        this.distancia = distancia;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }
}
