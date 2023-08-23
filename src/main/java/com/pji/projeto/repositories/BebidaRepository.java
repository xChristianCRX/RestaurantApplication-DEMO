package com.pji.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pji.projeto.models.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long>{
    
}
