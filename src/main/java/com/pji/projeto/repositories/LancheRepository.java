package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long>{
    
}
