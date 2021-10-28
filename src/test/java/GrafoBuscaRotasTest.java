import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.Grafo;
import com.rotacidade.domain.model.Vertice;
import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;

import java.math.BigDecimal;
import java.util.*;

public class GrafoBuscaRotasTest {

    private String destinoFinal;


    public static void main(String[] args) {

        
        Grafo grafo = new Grafo.GrafoBuilder()
                .criaEAdicionaVerticeNoGrafo("A")
                .criaEAdicionaVerticeNoGrafo("B")
                .criaEAdicionaVerticeNoGrafo("C")
                .criaEAdicionaVerticeNoGrafo("D")
                .criaEAdicionaVerticeNoGrafo("E")
                .adicionaAresta("A", "B", new BigDecimal(5))
                .adicionaAresta("B", "C", new BigDecimal(4))
                .adicionaAresta("C", "D", new BigDecimal(8))
                .adicionaAresta("D", "C", new BigDecimal(8))
                .adicionaAresta("D", "E", new BigDecimal(6))
                .adicionaAresta("A", "D", new BigDecimal(5))
                .adicionaAresta("C", "E", new BigDecimal(2))
                .adicionaAresta("E", "B", new BigDecimal(3))
                .adicionaAresta("A", "E", new BigDecimal(7))
                .builder();

        List<Vertice> pilha = new ArrayList<>();



        Vertice pontoInicial = grafo.buscaVertice("A");
        Vertice pontoFinal = grafo.buscaVertice("C");

        pilha.add(pontoInicial);

//        List<Vertice> visitados = new ArrayList<>();
//        visitados.add(primeiro);
//        boolean existirVertice = true;
//
//        while (existirVertice){
//
//            if (Objects.nonNull(primeiro)){
//
//            }
//
//
//        }

        GrafoBuscaRotasTest g = new GrafoBuscaRotasTest();

        System.out.println("Caminho de: " + pontoInicial.getBairro() + " a " + pontoFinal.getBairro());
        g.destinoFinal = pontoFinal.getBairro();
        g.printCaminhos(pontoInicial, pontoFinal);


    }

    public void printCaminhos(Vertice inicio, Vertice fim) {

        List<Vertice> verticesVisitados = new LinkedList<>();

        //caminho
        List<Vertice> caminho = new LinkedList<>();
        caminho.add(inicio);

        printTodosCaminhosUtil(inicio, fim, verticesVisitados, caminho, false);


    }

    public void printTodosCaminhosUtil(Vertice inicio, Vertice fim, List<Vertice> verticesVisitados, List<Vertice> caminho, boolean reprocessamento) {
        List<List<Vertice>> temp = new ArrayList<>();

        //origem igual ao destino
        if (inicio.getBairro().equals(fim.getBairro())) {

            System.out.println(caminho);
            //temp.add(caminho);
//            caminho.clear();

            while (caminho.size() > 1){
                int index = caminho.size() -1;
                caminho.remove(index);
            }
           return;
        }


        verticesVisitados.add(inicio);

        for (Aresta a : inicio.getListaArestaSaida()) {
            if (!verticesVisitados.contains(a.getFim())) {

                caminho.add(a.getFim());
                printTodosCaminhosUtil(a.getFim(), fim, verticesVisitados, caminho, true);

                verticesVisitados.remove(a.getFim());

            }


        }
        verticesVisitados.add(inicio);



    }



}
