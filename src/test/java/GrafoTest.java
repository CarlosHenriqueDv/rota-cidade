import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.Grafo;
import com.rotacidade.domain.model.Vertice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GrafoTest {

    public static void main(String[] args) {

        //Grafo Entrada: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
        //vertices A,B,C,D,E
        Grafo grafo = new Grafo();

        grafo.criaEAdicionaVerticeNoGrafo("A");
        grafo.criaEAdicionaVerticeNoGrafo("B");
        grafo.criaEAdicionaVerticeNoGrafo("C");
        grafo.criaEAdicionaVerticeNoGrafo("D");
        grafo.criaEAdicionaVerticeNoGrafo("E");


        grafo.adicionaAresta(new BigDecimal(5), grafo.buscaVertice("A"), grafo.buscaVertice("B"));
        grafo.adicionaAresta(new BigDecimal(4), grafo.buscaVertice("B"), grafo.buscaVertice("C"));
        grafo.adicionaAresta(new BigDecimal(8), grafo.buscaVertice("C"), grafo.buscaVertice("D"));
        grafo.adicionaAresta(new BigDecimal(6), grafo.buscaVertice("D"), grafo.buscaVertice("E"));
        grafo.adicionaAresta(new BigDecimal(5), grafo.buscaVertice("A"), grafo.buscaVertice("D"));
        grafo.adicionaAresta(new BigDecimal(2), grafo.buscaVertice("C"), grafo.buscaVertice("E"));
        grafo.adicionaAresta(new BigDecimal(3), grafo.buscaVertice("E"), grafo.buscaVertice("B"));
        grafo.adicionaAresta(new BigDecimal(7), grafo.buscaVertice("A"), grafo.buscaVertice("E"));



        List<Vertice> verticesVisitados = new ArrayList<>();
        List<Vertice> fila = new ArrayList<>();
        Vertice primeiro = grafo.getListaDeVertices().get(0);

        verticesVisitados.add(primeiro);
        System.out.println(primeiro.getBairro());
        fila.add(primeiro);
        while (fila.size() > 0){
            Vertice visitado = fila.get(0);

            for (Aresta arestaPercorrida : visitado.getListaArestaSaida()){
                Vertice proximo = arestaPercorrida.getFim();
                if (!verticesVisitados.contains(proximo)){
                    verticesVisitados.add(proximo);
                    System.out.println(proximo.getBairro());
                    fila.add(proximo);
                }

            }
            fila.remove(visitado);
        }



    }



}
