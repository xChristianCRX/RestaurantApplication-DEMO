package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Mesa;
import com.pji.projeto.repositories.MesaRepository;

import jakarta.transaction.Transactional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public Mesa findById(int id){
        Optional<Mesa> Mesa = this.mesaRepository.findById(id);
        return Mesa.orElseThrow(() -> new RuntimeException(
                "Mesa não cadastrada! Id: " + id + ", Tipo: " + Mesa.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Mesa create(Mesa Mesa){
        Mesa = this.mesaRepository.save(Mesa);
        return Mesa;
    }

    public void delete(int id){
        findById(id);
        try {
            this.mesaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
