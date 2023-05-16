package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Acrescimo;

@Repository
public interface AcrescimoRepository extends JpaRepository <Acrescimo, Long>{
    
}
