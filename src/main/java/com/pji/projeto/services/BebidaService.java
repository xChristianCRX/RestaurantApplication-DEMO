package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Bebida;
import com.pji.projeto.repositories.BebidaRepository;

import jakarta.transaction.Transactional;

@Service
public class BebidaService {
    
    @Autowired
    private BebidaRepository bebidaRepository;

    public Bebida findById(Long id){
        Optional<Bebida> bebida = this.bebidaRepository.findById(id);
        return bebida.orElseThrow(() -> new RuntimeException(
                "Bebida não cadastrada! Id: " + id + ", Tipo: " + Bebida.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Bebida create(Bebida bebida){
        bebida.setId(null);
        bebida = this.bebidaRepository.save(bebida);
        return bebida;
    }

    @Transactional //Envio de dados para o BDD
    public Bebida update(Bebida bebida){
        Bebida newBebida = findById(bebida.getId());
        newBebida.setPreco(bebida.getPreco());
        newBebida.setNome(bebida.getNome());
        newBebida.setLitragem(bebida.getLitragem());
        return this.bebidaRepository.save(newBebida);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.bebidaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
