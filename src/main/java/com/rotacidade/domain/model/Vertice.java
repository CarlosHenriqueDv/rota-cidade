package com.rotacidade.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vertice")
public class Vertice extends AbstractEntity<Long> {

    @NotEmpty
    private String bairro;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "inicio" ,targetEntity = Aresta.class)
    private List<Aresta> listaArestaEntrada;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fim", targetEntity = Aresta.class)
    private List<Aresta> listaArestaSaida;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Grafo.class)
    @JoinColumn(name = "grafo_id", foreignKey = @ForeignKey(name = "fk_vertice"))
    private Grafo grafo;

    public Vertice() {
    }

    public Vertice(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Aresta> getListaArestaEntrada() {
        return this.listaArestaEntrada == null ? new ArrayList<>() : listaArestaEntrada;
    }

    public void setListaArestaEntrada(ArrayList<Aresta> listaArestaEntrada) {
        this.listaArestaEntrada = listaArestaEntrada;
    }

    public List<Aresta> getListaArestaSaida() {
        return this.listaArestaSaida == null ? new ArrayList<>() : listaArestaSaida;
    }

    public void setListaArestaSaida(ArrayList<Aresta> listaArestaSaida) {
        this.listaArestaSaida = listaArestaSaida;
    }

    public void adicionaArestaEntrada(Aresta arestaEntrada){
        if (this.listaArestaEntrada == null){
            this.listaArestaEntrada = new ArrayList<>();
        }
        this.listaArestaEntrada.add(arestaEntrada);
    }

    public void adicionaArestaSaida(Aresta arestaSaida){
        if (this.listaArestaSaida == null){
            this.listaArestaSaida = new ArrayList<>();
        }
        this.listaArestaSaida.add(arestaSaida);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Vertice vertice = (Vertice) o;

        return bairro.equals(vertice.bairro);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + bairro.hashCode();
        return result;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
}
