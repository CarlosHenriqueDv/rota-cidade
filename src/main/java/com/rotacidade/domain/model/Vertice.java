package com.rotacidade.domain.model;

import java.util.ArrayList;

public class Vertice extends AbstractEntity<Long> {

    private String bairro;

    private ArrayList<Aresta> listaArestaEntrada;

    private ArrayList<Aresta> listaArestaSaida;

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

        if (bairro != null ? !bairro.equals(vertice.bairro) : vertice.bairro != null) return false;
        if (listaArestaEntrada != null ? !listaArestaEntrada.equals(vertice.listaArestaEntrada) : vertice.listaArestaEntrada != null)
            return false;
        return listaArestaSaida != null ? listaArestaSaida.equals(vertice.listaArestaSaida) : vertice.listaArestaSaida == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (listaArestaEntrada != null ? listaArestaEntrada.hashCode() : 0);
        result = 31 * result + (listaArestaSaida != null ? listaArestaSaida.hashCode() : 0);
        return result;
    }
}
