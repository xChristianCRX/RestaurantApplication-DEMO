package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lanche")
public class Lanche extends itemPedido{

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "ingredientes", length = 255, nullable = false)
    private String ingredientes;

    
}