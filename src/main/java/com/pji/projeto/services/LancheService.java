package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pji.projeto.models.Lanche;

import jakarta.transaction.Transactional;

@Service
public class LancheService {

//    private LancheRepository lancheRepository;
//
//    public Lanche findById(Long id){
//        Optional<Lanche> lanche = this.lancheRepository.findById(id);
//        return lanche.orElseThrow(() -> new RuntimeException(
//                "Lanche não cadastrado! Id: " + id + ", Tipo: " + Lanche.class.getName()));
//    }
//
//    @Transactional //Envio de dados para o BDD
//    public Lanche create(Lanche lanche){
//        lanche = this.lancheRepository.save(lanche);
//        return lanche;
//    }
//
//    @Transactional //Envio de dados para o BDD
//    public Lanche update(Lanche Lanche){
//        Lanche newLanche = findById(Lanche.getId());
//        newLanche.setPreco(Lanche.getPreco());
//        newLanche.setNome(Lanche.getNome());
//        newLanche.setIngredientes(Lanche.getIngredientes());
//        return this.lancheRepository.save(newLanche);
//    }
//
//    public void delete(Long id){
//        findById(id);
//        try {
//            this.lancheRepository.deleteById(id);
//        } catch (Exception e) {
//            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
//        }
//    }
}
