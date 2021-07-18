package com.rotacidade.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Entity
@Table(name = "vertice")
public class Vertice extends AbstractEntity<Long> {

    @NotEmpty
    private String bairro;

    private ArrayList<Aresta> listaArestaEntrada;

    private ArrayList<Aresta> listaArestaSaida;

    @ManyToOne
    private Grafo grafo;

    public Vertice(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public ArrayList<Aresta> getListaArestaEntrada() {
        return this.listaArestaEntrada == null ? new ArrayList<>() : listaArestaEntrada;
    }

    public void setListaArestaEntrada(ArrayList<Aresta> listaArestaEntrada) {
        this.listaArestaEntrada = listaArestaEntrada;
    }

    public ArrayList<Aresta> getListaArestaSaida() {
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
