package com.pji.projeto.controllers;

import com.pji.projeto.models.Acrescimo;
import com.pji.projeto.repositories.AcrescimoRepository;
import com.pji.projeto.services.AcrescimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/acrescimo")
@Validated
@RestController
public class AcrescimoController {

    @Autowired
    private AcrescimoRepository repository;
    @Autowired
    private AcrescimoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Acrescimo> findById(@PathVariable Long id){
        Acrescimo acrescimo = this.service.findById(id);
        return ResponseEntity.ok().body(acrescimo);
    }

    @GetMapping("/acrescimos")
    public ResponseEntity<List<Acrescimo>> findAll(){
        List<Acrescimo> acrescimos = this.repository.findAll();
        return ResponseEntity.ok().body(acrescimos);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Acrescimo acrescimo){
        this.service.create(acrescimo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(acrescimo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Acrescimo acrescimo, @PathVariable Long id){
        acrescimo.setId(id);
        this.service.update(acrescimo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
