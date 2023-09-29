package com.pji.projeto.controllers;

import com.pji.projeto.models.Lancamento;
import com.pji.projeto.repositories.LancamentoRepository;
import com.pji.projeto.services.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/lancamento")
@Validated
@RestController
public class LancamentoController {
    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private LancamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> findById(@PathVariable Long id){
        Lancamento lancamento = this.service.findById(id);
        return ResponseEntity.ok().body(lancamento);
    }

    @GetMapping("/lancamentos")
    public ResponseEntity<List<Lancamento>> findAll(){
        List<Lancamento> lancamentos = this.repository.findAll();
        return ResponseEntity.ok().body(lancamentos);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Lancamento lancamento){
        this.service.create(lancamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(lancamento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
