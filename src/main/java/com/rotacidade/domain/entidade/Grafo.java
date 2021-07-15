package com.rotacidade.domain.entidade;


import java.util.ArrayList;


public class Grafo extends AbstractEntity {

    ArrayList<Vertice> listaDeVertices;


    ArrayList<Aresta> listaDeArestas;

    public Grafo(ArrayList<Vertice> listaDeVertices, ArrayList<Aresta> listaDeArestas) {
        this.listaDeVertices = listaDeVertices;
        this.listaDeArestas = listaDeArestas;
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


}
