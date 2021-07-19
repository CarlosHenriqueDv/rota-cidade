package com.rotacidade.domain.model;


import com.rotacidade.domain.exception.RegraDeNegocioException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grafo")
public class Grafo extends AbstractEntity<Long> {

    @OneToMany(mappedBy = "grafo", cascade = CascadeType.PERSIST, targetEntity = Vertice.class)
    private List<Vertice> listaDeVertices;


    @OneToMany(mappedBy = "grafo", cascade = CascadeType.PERSIST, targetEntity = Aresta.class)
    private List<Aresta> listaDeArestas;

    public Grafo(ArrayList<Vertice> listaDeVertices, ArrayList<Aresta> listaDeArestas) {
        this.listaDeVertices = listaDeVertices;
        this.listaDeArestas = listaDeArestas;
    }

    public Grafo() {
        this.listaDeVertices = new ArrayList<>();
        this.listaDeArestas = new ArrayList<>();
    }

    public static class GrafoBuilder{
        private ArrayList<Vertice> listaDeVertices;
        private ArrayList<Aresta> listaDeArestas;

        {
            this.listaDeArestas = new ArrayList<>();
            this.listaDeVertices = new ArrayList<>();
        }

        public GrafoBuilder criaEAdicionaVerticeNoGrafo(String nomeVertice){
            Vertice vertice = new Vertice(nomeVertice);
            if(Objects.isNull(buscaVertice(nomeVertice))){
                adicionaVerticeNoGrafo(vertice);
            }

            return this;
        }
        public GrafoBuilder adicionaVerticeNoGrafo(Vertice vertice){
            if (listaDeVertices == null) {
                this.listaDeVertices = new ArrayList<>();
            }
            this.listaDeVertices.add(vertice);
            return this;

        }

        public GrafoBuilder adicionaAresta(String verticeOrigem, String verticeDestino, BigDecimal distancia){
            Vertice inicio = buscaVertice(verticeOrigem);
            Vertice fim = buscaVertice(verticeDestino);
            Aresta aresta = new Aresta(inicio, fim, distancia);

            inicio.adicionaArestaSaida(aresta);
            fim.adicionaArestaEntrada(aresta);

            this.listaDeArestas.add(aresta);
            return this;
        }

        private Vertice buscaVertice(String nomeVertice){
            return this.listaDeVertices.stream().filter(v -> v.getBairro().equals(nomeVertice)).findFirst().orElse(null);
        }

        public Grafo builder() throws RegraDeNegocioException {
            /*if (this.listaDeVertices.isEmpty() || this.listaDeVertices.size() < 2 || this.listaDeArestas.isEmpty()){
                throw new RegraDeNegocioException("Obrigatório ter pelo menos duas arestas e um vetice");*/
            //}else{
                return new Grafo(this.listaDeVertices, this.listaDeArestas);
            //}
        }


    }

    public List<Vertice> getListaDeVertices() {
        return listaDeVertices;
    }

    public void setListaDeVertices(ArrayList<Vertice> listaDeVertices) {
        this.listaDeVertices = listaDeVertices;
    }

    public List<Aresta> getListaDeArestas() {
        return listaDeArestas;
    }

    public void setListaDeArestas(ArrayList<Aresta> listaDeArestas) {
        this.listaDeArestas = listaDeArestas;
    }

}
