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
        AtomicReference<Grafo> grafo = new AtomicReference<>(new Grafo());

        validaArestas(arestas);

        arestas.forEach(a -> grafo.set(new Grafo.GrafoBuilder()
                .criaEAdicionaVerticeNoGrafo(a.getInicio().getBairro())
                .criaEAdicionaVerticeNoGrafo(a.getFim().getBairro())
                .adicionaAresta(a.getInicio().getBairro(), a.getFim().getBairro(), a.getDistancia())
                .builder()));

        return grafo.get();
    }

    public void validaArestas(List<Aresta> arestas) throws RegraDeNegocioException {

        arestas.forEach(a -> {
            if (a.getInicio()== null || a.getFim()== null || a.getDistancia()== null ){
                throw new RegraDeNegocioException("Não é permitido a criação de grafo com aresta sem um início, fim ou sem a distância");
            }
        });
    }
}
