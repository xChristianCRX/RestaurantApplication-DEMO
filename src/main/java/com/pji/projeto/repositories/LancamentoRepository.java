package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Lancamento;
import com.pji.projeto.models.EmbbedKeys.LancamentoPK;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, LancamentoPK>{
    
}
