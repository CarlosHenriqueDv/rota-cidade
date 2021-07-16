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

    @Override
    public String toString() {
        return "Aresta{" +
                "inicio=" + inicio +
                ", fim=" + fim +
                ", distancia=" + distancia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Aresta aresta = (Aresta) o;

        if (inicio != null ? !inicio.equals(aresta.inicio) : aresta.inicio != null) return false;
        if (fim != null ? !fim.equals(aresta.fim) : aresta.fim != null) return false;
        return distancia != null ? distancia.equals(aresta.distancia) : aresta.distancia == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (inicio != null ? inicio.hashCode() : 0);
        result = 31 * result + (fim != null ? fim.hashCode() : 0);
        result = 31 * result + (distancia != null ? distancia.hashCode() : 0);
        return result;
    }
}
