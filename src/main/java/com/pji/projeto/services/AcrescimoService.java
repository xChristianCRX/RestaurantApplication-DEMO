package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Acrescimo;
import com.pji.projeto.repositories.AcrescimoRepository;

import jakarta.transaction.Transactional;

@Service
public class AcrescimoService {
    
    @Autowired
    private AcrescimoRepository acrescimoRepository;

    public Acrescimo findById(Long id){
        Optional<Acrescimo> acrescimo = this.acrescimoRepository.findById(id);
        return acrescimo.orElseThrow(() -> new RuntimeException(
                "Acréscimo não cadastrado! Id: " + id + ", Tipo: " + Acrescimo.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Acrescimo create(Acrescimo acrescimo){
        acrescimo.setId(null);
        acrescimo = this.acrescimoRepository.save(acrescimo);
        return acrescimo;
    }

    @Transactional
    public Acrescimo update(Acrescimo acrescimo){
        Acrescimo newAcrescimo = findById(acrescimo.getId());
        newAcrescimo.setItem(acrescimo.getItem());
        newAcrescimo.setValor(acrescimo.getValor());
        return this.acrescimoRepository.save(newAcrescimo);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.acrescimoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
