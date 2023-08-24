package com.pji.projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.ItemPedido;
import com.pji.projeto.models.EmbbedKeys.ItemPedidoPK;
import com.pji.projeto.repositories.ItemPedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido findById(ItemPedidoPK id){
        ItemPedido itemPedido = this.itemPedidoRepository.findByAcrescimoAndItem(id.getItem(), id.getAcrescimo());
        return itemPedido.orElseThrow(() -> new RuntimeException(
                "itemPedido não cadastrada! Id: " + id + ", Tipo: " + ItemPedido.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public ItemPedido create(ItemPedido itemPedido){
        itemPedido.setId(null);
        itemPedido = this.itemPedidoRepository.save(itemPedido);
        return itemPedido;
    }

    @Transactional //Envio de dados para o BDD
    public ItemPedido update(ItemPedido itemPedido){
        ItemPedido newitemPedido = findById(itemPedido.getId());
        newitemPedido.setNome(itemPedido.getNome());
        newitemPedido.setIdade(itemPedido.getIdade());
        newitemPedido.setFuncao(itemPedido.getFuncao());
        newitemPedido.setEmail(itemPedido.getEmail());
        newitemPedido.setSenha(itemPedido.getSenha());
        return this.itemPedidoRepository.save(newitemPedido);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.itemPedidoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
