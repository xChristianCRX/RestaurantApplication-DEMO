package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Lanche;
import com.pji.projeto.repositories.LancheRepository;

import jakarta.transaction.Transactional;

@Service
public class LancheService {
    
    @Autowired
    private LancheRepository lancheRepository;

    public Lanche findById(Long id){
        Optional<Lanche> lanche = this.lancheRepository.findById(id);
        return lanche.orElseThrow(() -> new RuntimeException(
                "Lanche não cadastrado! Id: " + id + ", Tipo: " + Lanche.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Lanche create(Lanche Lanche){
        Lanche.setId(null);
        Lanche = this.lancheRepository.save(Lanche);
        return Lanche;
    }

    @Transactional //Envio de dados para o BDD
    public Lanche update(Lanche lanche){
        Lanche newLanche = findById(lanche.getId());
        newLanche.setNome(lanche.getNome());
        newLanche.setPreco(lanche.getPreco());
        newLanche.setIngredientes(lanche.getIngredientes());
        return this.lancheRepository.save(newLanche);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.lancheRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
