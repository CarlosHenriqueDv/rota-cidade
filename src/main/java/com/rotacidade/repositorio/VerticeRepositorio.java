package com.rotacidade.repositorio;


import com.rotacidade.domain.model.Vertice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VerticeRepositorio extends JpaRepository<Vertice, Long> {


    Vertice findByBairro(String nomeBairro);



}
