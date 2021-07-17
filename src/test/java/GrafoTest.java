import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.Grafo;
import com.rotacidade.domain.model.Vertice;
import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GrafoTest {

    public static void main(String[] args) {

        //Grafo Entrada: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
        //vertices A,B,C,D,E

        try {
            Grafo grafo2 = new Grafo();

            Grafo grafo = new Grafo.GrafoBuilder()
                    .criaEAdicionaVerticeNoGrafo("A")
                    .criaEAdicionaVerticeNoGrafo("B")
                    .criaEAdicionaVerticeNoGrafo("C")
                    .criaEAdicionaVerticeNoGrafo("D")
                    .adicionaAresta("A", "B", new BigDecimal(2))
                    .builder();


            List<Vertice> verticesVisitados = new ArrayList<>();
            List<Vertice> fila = new ArrayList<>();
            Vertice primeiro = grafo.getListaDeVertices().get(0);

            verticesVisitados.add(primeiro);
            //System.out.print(primeiro.getBairro()+ " ->");
            fila.add(primeiro);
            while (fila.size() > 0) {
                Vertice visitado = fila.get(0);

                for (Aresta arestaPercorrida : visitado.getListaArestaSaida()) {
                    Vertice proximo = arestaPercorrida.getFim();
                    if (!verticesVisitados.contains(proximo)) {
                        verticesVisitados.add(proximo);
                        System.out.print("Saida de: " + arestaPercorrida.getInicio().getBairro() + " para: " + proximo.getBairro());
                        System.out.println();
                        fila.add(proximo);
                    }

                }
                fila.remove(visitado);
            }

        } catch (CompilerException e) {
            e.printStackTrace();
        }


    }


}
