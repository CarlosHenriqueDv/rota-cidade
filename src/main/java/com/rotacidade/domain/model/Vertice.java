package com.rotacidade.domain.model;

import java.util.ArrayList;

public class Vertice extends AbstractEntity<Long> {

    private String bairro;

    private ArrayList<Aresta> listaArestaEntrada;

    private ArrayList<Aresta> listaArestaSaida;

    public Vertice(String bairro) {
        this.bairro = bairro;
        this.listaArestaEntrada  = new ArrayList<>();
        this.listaArestaSaida = new ArrayList<>();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public ArrayList<Aresta> getListaArestaEntrada() {
        return listaArestaEntrada;
    }

    public void setListaArestaEntrada(ArrayList<Aresta> listaArestaEntrada) {
        this.listaArestaEntrada = listaArestaEntrada;
    }

    public ArrayList<Aresta> getListaArestaSaida() {
        return listaArestaSaida;
    }

    public void setListaArestaSaida(ArrayList<Aresta> listaArestaSaida) {
        this.listaArestaSaida = listaArestaSaida;
    }

    public void adicionaArestaEntrada(Aresta arestaEntrada){
        this.listaArestaEntrada.add(arestaEntrada);
    }

    public void adicionaArestaSaida(Aresta arestaSaida){
        this.listaArestaSaida.add(arestaSaida);
    }
}
