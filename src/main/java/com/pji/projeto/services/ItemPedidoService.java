package com.pji.projeto.services;

import com.pji.projeto.models.ItemPedido;
import com.pji.projeto.repositories.ItemPedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository repository;

    public ItemPedido findById(Long id){
        Optional<ItemPedido> item = this.repository.findById(id);
        return item.orElseThrow(() -> new RuntimeException(
                "Acréscimo não cadastrado! Id: " + id + ", Tipo: " + ItemPedido.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public ItemPedido create(ItemPedido item){
        item.setId(null);
        item = this.repository.save(item);
        return item;
    }

    @Transactional
    public ItemPedido update(ItemPedido item){
        ItemPedido newItem = findById(item.getId());
        newItem.setItem(item.getItem());
        newItem.setAcrescimos(item.getAcrescimos());
        return this.repository.save(newItem);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
