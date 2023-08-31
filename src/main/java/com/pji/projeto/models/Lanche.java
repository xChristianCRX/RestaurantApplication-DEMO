package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lanches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lanche extends Menu {
    
    @Column(name = "nome", length = 100, unique = true)
    private String nome;

    @Column(name = "ingredientes", length = 255, nullable = false)
    private String ingredientes;

}
