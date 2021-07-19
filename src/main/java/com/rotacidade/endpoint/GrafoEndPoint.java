package com.rotacidade.endpoint;

import com.rotacidade.domain.gerente.GerenteGrafo;
import com.rotacidade.domain.model.Aresta;

import com.rotacidade.domain.model.Grafo;
import com.rotacidade.domain.model.Vertice;
import com.rotacidade.repositorio.ArestaRepositorio;
import com.rotacidade.repositorio.GrafoRepositorio;
import com.rotacidade.repositorio.VerticeRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grafo")
public class GrafoEndPoint {

    @Resource
    private GrafoRepositorio grafoRepositorio;

    @Resource
    private GerenteGrafo gerenteGrafo;

    @Resource
    private VerticeRepositorio verticeRepositorio;

    @Resource
    private ArestaRepositorio arestaRepositorio;


    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody List<Aresta> aresta){

        Grafo grafo = gerenteGrafo.buildGrafo(aresta);
        grafoRepositorio.save(grafo);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}
