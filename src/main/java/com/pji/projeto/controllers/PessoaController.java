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

import com.pji.projeto.models.Admin;
import com.pji.projeto.models.Atendente;
import com.pji.projeto.models.Garcom;
import com.pji.projeto.models.Pessoa;
import com.pji.projeto.repositories.AdminRepository;
import com.pji.projeto.repositories.AtendenteRepository;
import com.pji.projeto.repositories.GarcomRepository;
import com.pji.projeto.services.PessoaService;

import jakarta.validation.Valid;

@RequestMapping("/pessoa")
@Validated
@RestController
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AtendenteRepository atendenteRepository;
    @Autowired
    private GarcomRepository garcomRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa pessoa = this.pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Pessoa pessoa){
        this.pessoaService.create(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(pessoa.getId()).toUri();

        switch (pessoa.getFuncao().toUpperCase()) {
            case "ADMIN":
                Admin admin = new Admin();
                admin.setNome(pessoa.getNome());
                this.pessoaService.create(pessoa);
                break;

            case "GARCOM":
                Garcom garcom = new Garcom();
                garcom.setNome(pessoa.getNome());
                // Copiar outros atributos específicos de Garçom, se houver

                pessoaRepository.save(garçom);
                break;

            case "ATENDENTE":
                Atendente atendente = new Atendente();
                atendente.setNome(pessoa.getNome());
                // Copiar outros atributos específicos de Atendente, se houver

                pessoaRepository.save(atendente);
                break;

            default:
                return ResponseEntity.badRequest().body("Função inválida.");
        }

/*         if(pessoa.getFuncao().equalsIgnoreCase("admin")){
            Admin ad = new Admin();
            ad.setId(pessoa.getId());
            this.adminRepository.save(ad);
        }else if(pessoa.getFuncao().equalsIgnoreCase("atendente")){
            Atendente a = new Atendente();
            a.setId(pessoa.getId());
            this.atendenteRepository.save(a);
        }else if(pessoa.getFuncao().equalsIgnoreCase("garcom")){
            
            Garcom g = new Garcom();
            g.setId(pessoa.getId());
            this.garcomRepository.save(g);
        }
        
        return ResponseEntity.created(uri).build(); */

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
