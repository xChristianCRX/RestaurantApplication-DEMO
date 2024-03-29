package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.LancamentoItem;

@Repository
public interface LancamentoItemRepository extends JpaRepository<LancamentoItem, Long>{
    
}
