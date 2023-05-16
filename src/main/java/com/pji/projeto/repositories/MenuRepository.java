package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
    

