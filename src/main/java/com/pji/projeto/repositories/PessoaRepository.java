package com.pji.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.pji.projeto.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    UserDetails findByUsuario(String usuario);
}
