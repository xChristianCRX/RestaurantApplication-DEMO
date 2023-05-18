package com.pji.projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bebida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bebida extends Menu{
    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "litragem", length = 60, nullable = false)
    private String litragem;
}
