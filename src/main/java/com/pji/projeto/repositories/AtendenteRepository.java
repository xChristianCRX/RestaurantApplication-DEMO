package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
    
}