package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "porcao")
public class Porcao extends itemPedido{
    
    @Column(name = "tamanho", length = 60, nullable = false)
    private String tamanho;

    @Column(name = "tipo", length = 60, nullable = false)
    private String tipo;
}
