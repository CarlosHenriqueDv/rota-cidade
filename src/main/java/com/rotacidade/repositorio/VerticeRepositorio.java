package com.rotacidade.repositorio;

import com.rotacidade.domain.model.Aresta;
import org.springframework.data.repository.CrudRepository;


public interface VerticeRepositorio extends CrudRepository<Aresta, Long> {


}
