package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.domain.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer>{

}
