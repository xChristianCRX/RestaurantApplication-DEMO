package com.pji.projeto.services;

import com.pji.projeto.models.LancamentoItem;
import com.pji.projeto.repositories.LancamentoItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class LancamentoItemService {

    @Autowired
    private LancamentoItemRepository repository;

    public LancamentoItem findById(Long id) {
        Optional<LancamentoItem> item = this.repository.findById(id);
        return item.orElseThrow(() -> new RuntimeException(
                "Lançamento não cadastrado! Id: " + id + ", Tipo: " + LancamentoItem.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public LancamentoItem create(LancamentoItem lancamento) {
        Date date = new Date();
        String hour = new SimpleDateFormat("HH:mm:ss").format(date);
        lancamento.setId(null);
        lancamento.setHora(hour);
        lancamento = this.repository.save(lancamento);
        return lancamento;
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
