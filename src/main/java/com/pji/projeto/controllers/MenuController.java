package com.pji.projeto.controllers;

import com.pji.projeto.models.Bebida;
import com.pji.projeto.models.Lanche;
import com.pji.projeto.models.Porcao;
import com.pji.projeto.repositories.MenuRepository;
import com.pji.projeto.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/menu")
@Validated
@RestController
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuService menuService;

    @PostMapping("/lanche")
    public ResponseEntity<Void> createLanche(@Valid @RequestBody Lanche lanche) {
        this.menuService.createLanche(lanche);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(lanche.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/bebida")
    public ResponseEntity<Void> createBebida(@Valid @RequestBody Bebida bebida) {
        this.menuService.createBebida(bebida);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bebida.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/porcao")
    public ResponseEntity<Void> createPorcao(@Valid @RequestBody Porcao porcao) {
        this.menuService.createPorcao(porcao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(porcao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/lanche/{id}")
    public ResponseEntity<Lanche> findByIdLanche(@PathVariable Long id){
        Lanche lanche = this.menuService.findLanche(id);
        return ResponseEntity.ok().body(lanche);
    }

    @GetMapping("/bebida/{id}")
    public ResponseEntity<Bebida> findByIdBebida(@PathVariable Long id){
        Bebida bebida = this.menuService.findBebida(id);
        return ResponseEntity.ok().body(bebida);
    }

    @GetMapping("/porcao/{id}")
    public ResponseEntity<Porcao> findByIdPorcao(@PathVariable Long id){
        Porcao porcao = this.menuService.findPorcao(id);
        return ResponseEntity.ok().body(porcao);
    }

    @GetMapping("/lanches")
    public ResponseEntity<List<Lanche>> findAllLanches(){
        List<Lanche> lanches = this.menuRepository.findAllLanches();
        return ResponseEntity.ok().body(lanches);
    }

    @GetMapping("/bebidas")
    public ResponseEntity<List<Bebida>> findAllBebida(){
        List<Bebida> bebidas = this.menuRepository.findAllBebidas();
        return ResponseEntity.ok().body(bebidas);
    }

    @GetMapping("/porcoes")
    public ResponseEntity<List<Porcao>> findAllPorcao(){
        List<Porcao> porcoes = this.menuRepository.findAllPorcoes();
        return ResponseEntity.ok().body(porcoes);
    }

    @DeleteMapping("/lanche/{id}")
    public ResponseEntity<Void> deleteLanche(@PathVariable Long id){
        this.menuService.deleteLanche(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bebida/{id}")
    public ResponseEntity<Void> deleteBebida(@PathVariable Long id){
        this.menuService.deleteBebida(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/porcao/{id}")
    public ResponseEntity<Void> deletePorcao(@PathVariable Long id){
        this.menuService.deletePorcao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/lanche/{id}")
    public ResponseEntity<Void> updateLanche(@Valid @RequestBody Lanche lanche, @PathVariable Long id){
        lanche.setId(id);
        this.menuService.updateLanche(lanche);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/bebida/{id}")
    public ResponseEntity<Void> updateBebida(@Valid @RequestBody Bebida bebida, @PathVariable Long id){
        bebida.setId(id);
        this.menuService.updateBebida(bebida);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/porcao/{id}")
    public ResponseEntity<Void> updatePorcao(@Valid @RequestBody Porcao porcao, @PathVariable Long id){
        porcao.setId(id);
        this.menuService.updatePorcao(porcao);
        return ResponseEntity.noContent().build();
    }
}
