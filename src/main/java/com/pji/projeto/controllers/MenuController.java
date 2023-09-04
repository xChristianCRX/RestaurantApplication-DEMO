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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/menu")
@Validated
@RestController
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private LancheService lancheService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private BebidaService bebidaService;
    @Autowired
    private PorcaoService porcaoService;

    @PostMapping("/lanche")
    public ResponseEntity<Void> createLanche(@Valid @RequestBody Lanche lanche) {
        this.menuRepository.save(lanche);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(lanche.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/bebida")
    public ResponseEntity<Void> createLanche(@Valid @RequestBody Bebida bebida) {
        this.menuRepository.save(bebida);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bebida.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/porcao")
    public ResponseEntity<Void> createLanche(@Valid @RequestBody Porcao porcao) {
        this.menuRepository.save(porcao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(porcao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
