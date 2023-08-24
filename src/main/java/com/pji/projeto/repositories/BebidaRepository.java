package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long>{
    
}
