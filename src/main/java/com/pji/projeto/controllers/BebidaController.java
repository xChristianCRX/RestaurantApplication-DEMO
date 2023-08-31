package com.pji.projeto.controllers;

import java.net.URI;

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

import com.pji.projeto.models.Bebida;
import com.pji.projeto.services.BebidaService;

import jakarta.validation.Valid;

@RequestMapping("/bebida")
@Validated
@RestController
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> findById(@PathVariable Long id){
        Bebida bebida = this.bebidaService.findById(id);
        return ResponseEntity.ok().body(bebida);
    }

    //@PostMapping
    //public ResponseEntity<Void> create(@Valid @RequestBody Bebida bebida){
        //this.bebidaService.create(bebida);
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        //.path("/{id}").buildAndExpand(bebida.getId()).toUri();
       // return ResponseEntity.created(uri).build();
    //}

    //@PutMapping("/{id}")
    //public ResponseEntity<Void> update(@Valid @RequestBody Bebida bebida, @PathVariable Long id){
      //  bebida.setId(id);
       // this.bebidaService.update(bebida);
       // return ResponseEntity.noContent().build();
    //}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.bebidaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
