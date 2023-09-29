package com.pji.projeto.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pji.projeto.models.Mesa;
import com.pji.projeto.repositories.MesaRepository;
import com.pji.projeto.services.MesaService;

import jakarta.validation.Valid;

@RequestMapping("/mesa")
@Validated
@RestController
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;
    
    @Autowired
    private MesaService mesaService;

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> findById(@PathVariable int id){
        Mesa Mesa = this.mesaService.findById(id);
        return ResponseEntity.ok().body(Mesa);
    }

    @GetMapping("/mesas")
    public ResponseEntity<List<Mesa>> findAll(){
        List<Mesa> mesas = this.mesaRepository.findAll();
        return ResponseEntity.ok().body(mesas);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Mesa mesa){
        this.mesaService.create(mesa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(mesa.getNumeroMesa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.mesaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
