package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Garcom;

@Repository
public interface GarcomRepository extends JpaRepository<Garcom, Long>{
    
}
