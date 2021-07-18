package com.rotacidade.domain.gerente;

import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.Grafo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GerenteGrafo {


    public Grafo buildGrafo(List<Aresta> arestas){
        AtomicReference<Grafo> grafo = new AtomicReference<>(new Grafo());
        arestas.forEach(a -> {
            try {
                grafo.set(new Grafo.GrafoBuilder()
                        .criaEAdicionaVerticeNoGrafo(a.getInicio().getBairro())
                        .criaEAdicionaVerticeNoGrafo(a.getFim().getBairro())
                        .adicionaAresta(a.getInicio().getBairro(), a.getFim().getBairro(), a.getDistancia())
                        .builder());
            } catch (CompilerException e) {
                e.printStackTrace();
            }
        });

        return grafo.get();
    }

    public void validaArestasDoGrafo(List<Aresta> arestas){

        arestas.forEach(a -> {

        });
    }
}
