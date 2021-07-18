package com.rotacidade.domain.gerente;

import com.rotacidade.domain.exception.RegraDeNegocioException;
import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.Grafo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GerenteGrafo {


    public Grafo buildGrafo(List<Aresta> arestas) throws RegraDeNegocioException {

        validaArestas(arestas);

        Grafo.GrafoBuilder grafoBuilder = new Grafo.GrafoBuilder();

        arestas.forEach(aresta ->
                grafoBuilder.criaEAdicionaVerticeNoGrafo(aresta.getInicio().getBairro())
                .criaEAdicionaVerticeNoGrafo(aresta.getFim().getBairro())
                .adicionaAresta(aresta.getInicio().getBairro(), aresta.getFim().getBairro(), aresta.getDistancia()));
        Grafo grafo = grafoBuilder.builder();

        grafo.getListaDeVertices().forEach(v -> v.setGrafo(grafo));
        grafo.getListaDeArestas().forEach(a -> a.setGrafo(grafo));
        return grafo;
    }

    public void validaArestas(List<Aresta> arestas) throws RegraDeNegocioException {

        arestas.forEach(a -> {
            if (a.getInicio()== null || a.getFim()== null || a.getDistancia()== null ){
                throw new RegraDeNegocioException("Não é permitido a criação de grafo com aresta sem um início, fim ou sem a distância");
            }

            if (a.getInicio().equals(a.getFim())){
                throw new RegraDeNegocioException("A origem não pode ser igual ao destino");
            }
        });
    }
}
