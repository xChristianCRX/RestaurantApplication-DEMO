package com.pji.projeto.controllers;

import com.pji.projeto.models.Pedido;
import com.pji.projeto.repositories.PedidoRepository;
import com.pji.projeto.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/pedido")
@Validated
@RestController
public class PedidoController {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido pedido = this.service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidos = this.repository.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Pedido pedido){
        this.service.create(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Pedido pedido, @PathVariable Long id){
        pedido.setId(id);
        this.service.update(pedido);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
