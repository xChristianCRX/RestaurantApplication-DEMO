package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Porcao;
import com.pji.projeto.repositories.PorcaoRepository;

import jakarta.transaction.Transactional;

@Service
public class PorcaoService {

    @Autowired
    private PorcaoRepository porcaoRepository;

    public Porcao findById(Long id){
        Optional<Porcao> porcao = this.porcaoRepository.findById(id);
        return porcao.orElseThrow(() -> new RuntimeException(
                "Porcao não cadastrada! Id: " + id + ", Tipo: " + Porcao.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Porcao create(Porcao Porcao){
        Porcao.setId(null);
        Porcao = this.porcaoRepository.save(Porcao);
        return Porcao;
    }

    @Transactional //Envio de dados para o BDD
    public Porcao update(Porcao Porcao){
        Porcao newPorcao = findById(Porcao.getId());
        newPorcao.setPreco(Porcao.getPreco());
        newPorcao.setTamanho(Porcao.getTamanho());
        newPorcao.setTipo(Porcao.getTipo());
        return this.porcaoRepository.save(newPorcao);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.porcaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
