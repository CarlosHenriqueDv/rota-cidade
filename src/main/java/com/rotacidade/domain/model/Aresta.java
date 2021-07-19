package com.rotacidade.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "aresta")
public class Aresta extends AbstractEntity<Long> {

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Vertice.class)
    @JoinColumn(name = "inicio_id", foreignKey = @ForeignKey(name = "fk_aresta_inicio"))
    private Vertice inicio;

    @ManyToOne(cascade = CascadeType.PERSIST,targetEntity = Vertice.class)
    @JoinColumn(name = "fim_id", foreignKey = @ForeignKey(name = "fk_aresta_fim"))
    private Vertice fim;

    private BigDecimal distancia;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Grafo.class)
    @JoinColumn(name = "grafo_id", foreignKey = @ForeignKey(name = "fk_aresta_grafo"))
    private Grafo grafo;

    public Aresta() {
    }

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

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
}
