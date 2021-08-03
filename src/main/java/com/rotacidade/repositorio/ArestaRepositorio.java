package com.rotacidade.repositorio;

import com.rotacidade.domain.model.Aresta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArestaRepositorio extends JpaRepository<Aresta, Long> {
}
