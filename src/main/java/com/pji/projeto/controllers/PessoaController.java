package com.pji.projeto.controllers;

import java.net.URI;
import java.util.List;

import com.pji.projeto.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pji.projeto.models.Pessoa;
import com.pji.projeto.services.PessoaService;

import jakarta.validation.Valid;

@RequestMapping("/pessoa")
@Validated
@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa pessoa = this.pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> pessoas = this.pessoaRepository.findAll();
        return ResponseEntity.ok().body(pessoas);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Pessoa pessoa){
        this.pessoaService.create(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Pessoa pessoa, @PathVariable Long id){
        pessoa.setId(id);
        this.pessoaService.update(pessoa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
