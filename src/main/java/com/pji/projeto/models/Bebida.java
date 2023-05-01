package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bebida")
public class Bebida extends itemPedido {
    
    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "litragem", length = 60, nullable = false)
    private String litragem;
}
