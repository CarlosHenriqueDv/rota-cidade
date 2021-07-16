package com.rotacidade.domain.model;


import java.math.BigDecimal;
import java.util.ArrayList;


public class Grafo extends AbstractEntity<Long> {

    private ArrayList<Vertice> listaDeVertices;


    private ArrayList<Aresta> listaDeArestas;

    public Grafo(ArrayList<Vertice> listaDeVertices, ArrayList<Aresta> listaDeArestas) {
        this.listaDeVertices = listaDeVertices;
        this.listaDeArestas = listaDeArestas;
    }

    public Grafo() {
        this.listaDeVertices = new ArrayList<>();
        this.listaDeArestas = new ArrayList<>();
    }

    public ArrayList<Vertice> getListaDeVertices() {
        return listaDeVertices;
    }

    public void setListaDeVertices(ArrayList<Vertice> listaDeVertices) {
        this.listaDeVertices = listaDeVertices;
    }

    public ArrayList<Aresta> getListaDeArestas() {
        return listaDeArestas;
    }

    public void setListaDeArestas(ArrayList<Aresta> listaDeArestas) {
        this.listaDeArestas = listaDeArestas;
    }

    public void criaEAdicionaVerticeNoGrafo(String nomeVertice){
        Vertice vertice = new Vertice(nomeVertice);
        adicionaVerticeNoGrafo(vertice);
    }

    private void adicionaVerticeNoGrafo(Vertice vertice){
        if (listaDeVertices == null) {
            this.listaDeVertices = new ArrayList<>();
        }
            this.listaDeVertices.add(vertice);

    }

    public void adicionaAresta(Vertice verticeOrigem, Vertice verticeDestino, BigDecimal distancia){
        Vertice inicio = buscaVertice(verticeOrigem.getBairro());
        Vertice fim = buscaVertice(verticeDestino.getBairro());
        Aresta aresta = new Aresta(inicio, fim, distancia);

        verticeOrigem.adicionaArestaSaida(aresta);
        verticeDestino.adicionaArestaEntrada(aresta);

        this.listaDeArestas.add(aresta);
    }

    public Vertice buscaVertice(String nomeVertice){
        return this.listaDeVertices.stream().filter(v -> v.getBairro().equals(nomeVertice)).findFirst().orElse(null);
    }


}
