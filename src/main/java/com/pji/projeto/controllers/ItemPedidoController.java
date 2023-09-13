package com.pji.projeto.controllers;

import com.pji.projeto.models.ItemPedido;
import com.pji.projeto.repositories.ItemPedidoRepository;
import com.pji.projeto.services.ItemPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/itemPedido")
@Validated
@RestController
public class ItemPedidoController {
    @Autowired
    private ItemPedidoRepository repository;
    @Autowired
    private ItemPedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Long id){
        ItemPedido item = this.service.findById(id);
        return ResponseEntity.ok().body(item);
    }

    @GetMapping("/itens")
    public ResponseEntity<List<ItemPedido>> findAll(){
        List<ItemPedido> itens = this.repository.findAll();
        return ResponseEntity.ok().body(itens);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ItemPedido item){
        this.service.create(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ItemPedido item, @PathVariable Long id){
        item.setId(id);
        this.service.update(item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
