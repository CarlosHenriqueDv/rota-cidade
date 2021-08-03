package com.rotacidade.repositorio;


import com.rotacidade.domain.model.Grafo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GrafoRepositorio extends JpaRepository<Grafo, Long> {


}
