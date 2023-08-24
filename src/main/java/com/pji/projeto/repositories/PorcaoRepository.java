package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Porcao;

@Repository
public interface PorcaoRepository extends JpaRepository<Porcao, Long>{
    
}
