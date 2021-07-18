package com.rotacidade.repositorio;

import com.rotacidade.domain.model.Aresta;
import com.rotacidade.domain.model.Grafo;
import org.springframework.data.repository.CrudRepository;


public interface GrafoRepositorio extends CrudRepository<Grafo, Long> {


}
