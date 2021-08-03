package com.rotacidade.domain.gerente;

import com.rotacidade.domain.exception.RegraDeNegocioException;
import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.DTO.GrafoDTO;
import com.rotacidade.domain.model.Grafo;
import com.rotacidade.domain.model.Vertice;
import com.rotacidade.repositorio.VerticeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class GerenteGrafo {

    @Resource
    private VerticeRepositorio verticeRepositorio;


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

    public Map<Long, List<GrafoDTO>> preencherGrafoDTO(Grafo grafo){
        List<GrafoDTO> grafoDTOList = new ArrayList<>();
        Map<Long, List<GrafoDTO>> mapa = new LinkedHashMap<>();

        grafo.getListaDeArestas().forEach(g ->
        {
            GrafoDTO grafoDTO = new GrafoDTO(g.getInicio().getBairro(), g.getFim().getBairro(), g.getDistancia());
            grafoDTOList.add(grafoDTO);

        });
        mapa.put(grafo.getId(), grafoDTOList);

        return mapa;

    }

    public Grafo constroiRotas(String inicio, String fim, BigDecimal maximoParada){

        Grafo grafo = verticeRepositorio.findByBairro(inicio).getGrafo();


        return null;
    }
}
