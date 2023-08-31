package com.pji.projeto.services;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.projeto.models.Pedido;
import com.pji.projeto.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Long id){
        Optional<Pedido> pedido = this.pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new RuntimeException(
                "pedido não cadastrada! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    @Transactional //Envio de dados para o BDD
    public Pedido create(Pedido pedido){
        pedido.setId(null);
        pedido = this.pedidoRepository.save(pedido);
        return pedido;
    }

    @Transactional //Envio de dados para o BDD
    public Pedido update(Pedido pedido){
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm");
        Pedido newPedido = findById(pedido.getId());
        newPedido.setNumeroMesa(pedido.getNumeroMesa());
        newPedido.setHora(hora.toString());
        return this.pedidoRepository.save(newPedido);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.pedidoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
